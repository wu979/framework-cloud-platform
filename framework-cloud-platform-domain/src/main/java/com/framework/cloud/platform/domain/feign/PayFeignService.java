package com.framework.cloud.platform.domain.feign;

import com.framework.cloud.common.result.Result;
import com.framework.cloud.platform.common.dto.PayOrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 *
 * @author wusiwei
 */
@FeignClient(contextId = "PayFeignService", value = "${client.pay}", decode404 = true)
public interface PayFeignService {

    @PostMapping(value = "/pay-order/save")
    Result<Boolean> save(@RequestBody PayOrderDTO param);
}
