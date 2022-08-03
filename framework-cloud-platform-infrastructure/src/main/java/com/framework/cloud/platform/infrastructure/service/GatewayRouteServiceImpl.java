package com.framework.cloud.platform.infrastructure.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.utils.AssertUtil;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.common.utils.FastJsonUtil;
import com.framework.cloud.common.utils.StringUtil;
import com.framework.cloud.platform.common.constant.PlatformConstant;
import com.framework.cloud.platform.common.dto.GatewayFastRouteDTO;
import com.framework.cloud.platform.common.dto.GatewayRouteDTO;
import com.framework.cloud.platform.common.dto.GatewayRoutePageDTO;
import com.framework.cloud.platform.common.msg.PlatformMsg;
import com.framework.cloud.platform.common.vo.GatewayRouteInfoVO;
import com.framework.cloud.platform.common.vo.GatewayRouteListVO;
import com.framework.cloud.platform.common.vo.GatewayRoutePageVO;
import com.framework.cloud.platform.domain.entity.GatewayRoute;
import com.framework.cloud.platform.domain.event.GatewayRouteDeleteEvent;
import com.framework.cloud.platform.domain.event.GatewayRouteEvent;
import com.framework.cloud.platform.domain.repository.GatewayRouteRepository;
import com.framework.cloud.platform.domain.service.GatewayRouteService;
import com.framework.cloud.platform.infrastructure.mq.PlatformPublish;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态路由 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class GatewayRouteServiceImpl implements GatewayRouteService {

    private final GatewayRouteRepository gatewayRouteRepository;
    private final PlatformPublish platformPublish;

    @Override
    public PageVO<GatewayRoutePageVO> page(GatewayRoutePageDTO param) {
        return gatewayRouteRepository.page(param);
    }

    @Override
    public List<GatewayRouteListVO> list() {
        List<GatewayRouteListVO> gatewayRouteList = gatewayRouteRepository.routeList();
        if (CollectionUtil.isEmpty(gatewayRouteList)) {
            return CollectionUtil.newArrayList();
        }
        return gatewayRouteList;
    }

    @Override
    public GatewayRouteInfoVO info(Long id) {
        return gatewayRouteRepository.info(id);
    }

    @Override
    public boolean saveUpdate(GatewayRouteDTO param) {
        GatewayRoute gatewayRoute;
        GatewayRoute exist = gatewayRouteRepository.getByName(param.getName());
        boolean saveOrUpdate;
        if (ObjectUtil.isNull(param.getId())) {
            AssertUtil.nonNull(exist, PlatformMsg.GATEWAY_EXISTS.getMsg());
            gatewayRoute = new GatewayRoute();
            CopierUtil.copyProperties(param, gatewayRoute);
            saveOrUpdate = true;
        } else {
            gatewayRoute = gatewayRouteRepository.getByIdNotNull(param.getId());
            if (ObjectUtil.isNotNull(exist)) {
                AssertUtil.isTrue(gatewayRoute.getId().equals(exist.getId()), PlatformMsg.GATEWAY_EXISTS.getMsg());
            }
            CopierUtil.copyProperties(param, gatewayRoute);
            saveOrUpdate = false;
        }
        gatewayRoute.setPredicates(FastJsonUtil.toJSONString(param.getPredicateList()));
        gatewayRoute.setFilters(FastJsonUtil.toJSONString(param.getFilterList()));
        return publishGatewayRoute(saveOrUpdate, gatewayRoute);
    }

    @Override
    public boolean fastSave(GatewayFastRouteDTO param) {
        GatewayRoute exist = gatewayRouteRepository.getByName(param.getName());
        AssertUtil.nonNull(exist, PlatformMsg.GATEWAY_EXISTS.getMsg());
        String name = param.getName();
        String path = param.getPath();
        if (!StringUtil.startsWith(path, PlatformConstant.LB)) {
            path = PlatformConstant.LB + path;
        }
        GatewayRoute gatewayRoute = new GatewayRoute();
        gatewayRoute.setName(name);
        gatewayRoute.setPath(path);
        gatewayRoute.setPredicates(predicates(name));
        gatewayRoute.setFilters(filters(name));
        gatewayRoute.setSort(param.getSort());
        gatewayRoute.setRemarks(param.getRemarks());
        return publishGatewayRoute(Boolean.TRUE, gatewayRoute);
    }

    @Override
    public boolean enable(Long id, boolean enable) {
        GatewayRoute gatewayRoute = gatewayRouteRepository.getByIdNotNull(id);
        if (enable) {
            AssertUtil.isFalse(gatewayRoute.getEnable(), PlatformMsg.GATEWAY_ENABLE.getMsg());
            gatewayRoute.setEnable(true);
            return publishGatewayRoute(true, gatewayRoute);
        } else {
            AssertUtil.isTrue(gatewayRoute.getEnable(), PlatformMsg.GATEWAY_DISABLE.getMsg());
            gatewayRoute.setEnable(false);
            boolean flag = gatewayRouteRepository.updateById(gatewayRoute);
            if (flag) {
                GatewayRouteDeleteEvent event = new GatewayRouteDeleteEvent(gatewayRoute.getName());
                boolean delete = platformPublish.publishGatewayRoute(event);
                AssertUtil.isTrue(delete, PlatformMsg.PUBLISH_GATEWAY_ROUTE_ERROR.getMsg());
                return true;
            }
        }
        return false;
    }

    public String predicates(String name) {
        List<GatewayRouteDTO.RoutePredicatesDTO> predicateList = new ArrayList<>();
        GatewayRouteDTO.RoutePredicatesDTO.RoutePredicatesArgsDTO args = new GatewayRouteDTO.RoutePredicatesDTO.RoutePredicatesArgsDTO(MessageFormat.format(PlatformConstant.PREDICATES_ARGS, name));
        GatewayRouteDTO.RoutePredicatesDTO predicates = new GatewayRouteDTO.RoutePredicatesDTO(args, PlatformConstant.PREDICATES_NAME);
        predicateList.add(predicates);
        return FastJsonUtil.toJSONString(predicateList);
    }

    public String filters(String name) {
        List<GatewayRouteDTO.RouteFiltersDTO> filtersList = new ArrayList<>();
        GatewayRouteDTO.RouteFiltersDTO.RouteFiltersArgsDTO args = new GatewayRouteDTO.RouteFiltersDTO.RouteFiltersArgsDTO(MessageFormat.format(PlatformConstant.FILTER_ARGS, name));
        GatewayRouteDTO.RouteFiltersDTO filters = new GatewayRouteDTO.RouteFiltersDTO(args, PlatformConstant.FILTER_NAME);
        filtersList.add(filters);
        return FastJsonUtil.toJSONString(filtersList);
    }

    public boolean publishGatewayRoute(Boolean saveOrUpdate, GatewayRoute gatewayRoute) {
        boolean flag = gatewayRouteRepository.saveOrUpdate(gatewayRoute);
        if (flag && BooleanUtil.isTrue(gatewayRoute.getEnable())) {
            GatewayRouteEvent event = new GatewayRouteEvent();
            CopierUtil.copyProperties(gatewayRoute, event);
            event.setSaveOrUpdate(saveOrUpdate);
            boolean publish = platformPublish.publishGatewayRoute(event);
            AssertUtil.isTrue(publish, PlatformMsg.PUBLISH_GATEWAY_ROUTE_ERROR.getMsg());
        }
        return flag;
    }

}