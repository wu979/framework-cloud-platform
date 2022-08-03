package com.framework.cloud.platform.infrastructure.mq.publish;

import com.framework.cloud.platform.domain.event.GatewayRouteDeleteEvent;
import com.framework.cloud.platform.domain.event.GatewayRouteEvent;
import com.framework.cloud.platform.infrastructure.mq.PlatformPublish;
import com.framework.cloud.platform.infrastructure.mq.channel.GatewayRouteChannel;
import com.framework.cloud.platform.infrastructure.mq.channel.GatewayRouteDeleteChannel;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author wusiwei
 */
@Component
@AllArgsConstructor
@EnableBinding({GatewayRouteChannel.class, GatewayRouteDeleteChannel.class})
public class PlatformPublishImpl implements PlatformPublish {

    private final GatewayRouteChannel gatewayRouteChannel;
    private final GatewayRouteDeleteChannel gatewayRouteDeleteChannel;

    @Override
    public boolean publishGatewayRoute(GatewayRouteEvent event) {
        return gatewayRouteChannel.output().send(MessageBuilder.withPayload(event).build(), 2000L);
    }

    @Override
    public boolean publishGatewayRoute(GatewayRouteDeleteEvent event) {
        return gatewayRouteDeleteChannel.output().send(MessageBuilder.withPayload(event).build(), 2000L);
    }
}
