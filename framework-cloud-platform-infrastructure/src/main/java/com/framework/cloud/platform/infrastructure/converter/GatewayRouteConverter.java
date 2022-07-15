package com.framework.cloud.platform.infrastructure.converter;

import com.framework.cloud.platform.common.vo.GatewayRouteInfoVO;
import com.framework.cloud.platform.common.vo.GatewayRouteListVO;
import com.framework.cloud.platform.domain.entity.GatewayRoute;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 动态路由 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface GatewayRouteConverter {

    /**
     * 动态路由 详情转换
     *
     * @param gatewayRoute 实体
     * @return 详情
     */
    GatewayRouteInfoVO info(GatewayRoute gatewayRoute);

    /**
     * 动态路由 列表转换
     *
     * @param routeList 列表
     * @return 列表
     */
    List<GatewayRouteListVO> routeList(List<GatewayRoute> routeList);
}