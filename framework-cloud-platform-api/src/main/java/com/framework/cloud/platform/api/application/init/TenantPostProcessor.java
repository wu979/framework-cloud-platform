package com.framework.cloud.platform.api.application.init;

import com.framework.cloud.cache.cache.LocalCache;
import com.framework.cloud.cache.cache.RedisCache;
import com.framework.cloud.core.event.ApplicationInitializingEvent;
import com.framework.cloud.platform.common.constant.PlatformConstant;
import com.framework.cloud.platform.common.vo.TenantVO;
import com.framework.cloud.platform.domain.service.TenantService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wusiwei
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TenantPostProcessor implements ApplicationListener<ApplicationInitializingEvent> {

    private final LocalCache localCache;
    private final RedisCache redisCache;
    private final TenantService tenantService;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationInitializingEvent event) {
        log.info("Initialized tenants");
        List<TenantVO> list = tenantService.list();
        Map<String, TenantVO> map = list.stream().collect(Collectors.toMap(TenantVO::getCode, Function.identity()));
        int count = 0;
        for (Map.Entry<String, TenantVO> row : map.entrySet()) {
            String key = PlatformConstant.TENANT + row.getKey();
            TenantVO value = row.getValue();
            localCache.put(key, value);
            redisCache.put(key, value, PlatformConstant.TENANT_TIME, TimeUnit.MINUTES);
            count ++;
        }
        log.info("Successfully initialized " + count + " tenants");
    }
}
