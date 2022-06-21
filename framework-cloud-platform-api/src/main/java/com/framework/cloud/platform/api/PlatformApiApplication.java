package com.framework.cloud.platform.api;

import com.framework.cloud.core.annotation.FrameworkApplication;
import com.framework.cloud.feign.annotation.EnableFeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableFeignInterceptor
@EnableDiscoveryClient
@FrameworkApplication
public class PlatformApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApiApplication.class, args);
    }

}
