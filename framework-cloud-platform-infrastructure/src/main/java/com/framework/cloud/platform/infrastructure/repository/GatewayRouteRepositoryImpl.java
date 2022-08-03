package com.framework.cloud.platform.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.platform.common.dto.GatewayRoutePageDTO;
import com.framework.cloud.platform.common.vo.GatewayRouteInfoVO;
import com.framework.cloud.platform.common.vo.GatewayRouteListVO;
import com.framework.cloud.platform.common.vo.GatewayRoutePageVO;
import com.framework.cloud.platform.domain.entity.GatewayRoute;
import com.framework.cloud.platform.domain.repository.GatewayRouteRepository;
import com.framework.cloud.platform.infrastructure.converter.GatewayRouteConverter;
import com.framework.cloud.platform.infrastructure.mapper.GatewayRouteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 动态路由 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class GatewayRouteRepositoryImpl extends BaseRepositoryImpl<GatewayRouteMapper, GatewayRoute> implements GatewayRouteRepository {

    private final GatewayRouteConverter gatewayRouteConverter;

    @Override
    public PageVO<GatewayRoutePageVO> page(GatewayRoutePageDTO param) {
        Page<GatewayRoutePageVO> page = PageParam.buildOrder(param);
        IPage<GatewayRoutePageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public List<GatewayRouteListVO> routeList() {
        LambdaQueryWrapper<GatewayRoute> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GatewayRoute::getEnable, Boolean.TRUE);
        List<GatewayRoute> list = this.list(wrapper);
        return gatewayRouteConverter.routeList(list);
    }

    @Override
    public GatewayRouteInfoVO info(Long id) {
        GatewayRoute gatewayRoute = this.getById(id);
        return gatewayRouteConverter.info(gatewayRoute);
    }

    @Override
    public GatewayRoute getByName(String name) {
        LambdaQueryWrapper<GatewayRoute> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GatewayRoute::getName, name);
        return this.getOne(wrapper);
    }
}