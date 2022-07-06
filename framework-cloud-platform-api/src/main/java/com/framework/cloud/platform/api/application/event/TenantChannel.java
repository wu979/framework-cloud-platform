package com.framework.cloud.platform.api.application.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 *
 *
 * @author wusiwei
 */
public interface TenantChannel {

    String OUT = "tenant-out-channel";

    String IN = "tenant-in-channel";

    @Output(OUT)
    SubscribableChannel out();

    @Input(IN)
    SubscribableChannel input();
}
