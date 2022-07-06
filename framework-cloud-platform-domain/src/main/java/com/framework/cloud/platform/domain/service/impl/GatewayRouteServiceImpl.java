package com.framework.cloud.platform.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.utils.AssertUtil;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.platform.common.dto.GatewayRouteDTO;
import com.framework.cloud.platform.common.dto.GatewayRoutePageDTO;
import com.framework.cloud.platform.common.msg.PlatformMsg;
import com.framework.cloud.platform.common.vo.GatewayRouteInfoVO;
import com.framework.cloud.platform.common.vo.GatewayRoutePageVO;
import com.framework.cloud.platform.domain.entity.GatewayRoute;
import com.framework.cloud.platform.domain.repository.GatewayRouteRepository;
import com.framework.cloud.platform.domain.service.GatewayRouteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    @Override
    public PageVO<GatewayRoutePageVO> page(GatewayRoutePageDTO param) {
        return gatewayRouteRepository.page(param);
    }

    @Override
    public GatewayRouteInfoVO info(Long id) {
        return gatewayRouteRepository.info(id);
    }

    @Override
    public boolean saveUpdate(GatewayRouteDTO param) {
        GatewayRoute gatewayRoute;
        GatewayRoute exist = gatewayRouteRepository.getByName(param.getName());
        if (ObjectUtil.isNull(param.getId())) {
            AssertUtil.nonNull(exist, PlatformMsg.GATEWAY_EXISTS.getMsg());
            gatewayRoute = new GatewayRoute();
            CopierUtil.copyProperties(param, gatewayRoute);
        } else {
            gatewayRoute = gatewayRouteRepository.getByIdNotNull(param.getId());
            if (ObjectUtil.isNotNull(exist)) {
                AssertUtil.isTrue(gatewayRoute.getId().equals(exist.getId()), PlatformMsg.GATEWAY_EXISTS.getMsg());
            }
            CopierUtil.copyProperties(param, gatewayRoute);
        }
        return gatewayRouteRepository.saveOrUpdate(gatewayRoute);
    }

    @Override
    public boolean removes(List<Long> ids) {
        return gatewayRouteRepository.removeByIds(ids);
    }

}