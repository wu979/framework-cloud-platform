package com.framework.cloud.platform.api.application.event;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 *
 *
 * @author wusiwei
 */
@EnableBinding({TenantChannel.class})
public class TenantSubscribe {

    @StreamListener(TenantChannel.IN)
    public void testMessage() {
        System.out.println();
    }
}
