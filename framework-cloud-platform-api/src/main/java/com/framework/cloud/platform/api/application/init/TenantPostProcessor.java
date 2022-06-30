package com.framework.cloud.platform.api.application.init;

import com.framework.cloud.core.event.ApplicationInitializingEvent;
import com.framework.cloud.platform.common.vo.TenantVO;
import com.framework.cloud.platform.domain.service.TenantService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 * @author wusiwei
 */
@Component
@RequiredArgsConstructor
public class TenantPostProcessor implements ApplicationListener<ApplicationInitializingEvent> {

    private final TenantService tenantService;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationInitializingEvent event) {
        List<TenantVO> list = tenantService.list();

    }
}
