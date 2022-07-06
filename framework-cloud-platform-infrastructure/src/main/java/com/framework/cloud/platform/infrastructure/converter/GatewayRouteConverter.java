package com.framework.cloud.platform.infrastructure.converter;

import com.framework.cloud.platform.common.vo.*;
import com.framework.cloud.platform.domain.entity.GatewayRoute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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

}