package com.framework.cloud.platform.infrastructure.mq.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 网关动态路由 领域事件
 *
 * @author wusiwei
 */
public interface GatewayRouteDeleteChannel {

    String OUT = "gateway-route-delete-channel";

    @Output(OUT)
    MessageChannel output();

}
