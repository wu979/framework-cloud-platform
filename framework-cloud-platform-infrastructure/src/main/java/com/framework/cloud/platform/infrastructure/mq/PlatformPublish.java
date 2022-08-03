package com.framework.cloud.platform.infrastructure.mq;

import com.framework.cloud.platform.domain.event.GatewayRouteDeleteEvent;
import com.framework.cloud.platform.domain.event.GatewayRouteEvent;

/**
 * 平台领域事件发布接口
 *
 * @author wusiwei
 */
public interface PlatformPublish {

    /**
     * 发布 动态网关事件
     *
     * @param event 事件
     * @return bool
     */
    boolean publishGatewayRoute(GatewayRouteEvent event);

    /**
     * 删除 动态网关事件
     *
     * @param event 事件
     * @return bool
     */
    boolean publishGatewayRoute(GatewayRouteDeleteEvent event);
}
