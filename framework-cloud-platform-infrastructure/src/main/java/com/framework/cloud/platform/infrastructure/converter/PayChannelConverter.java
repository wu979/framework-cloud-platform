package com.framework.cloud.platform.infrastructure.converter;

import com.framework.cloud.platform.common.vo.*;
import com.framework.cloud.platform.domain.entity.PayChannel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 支付渠道 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface PayChannelConverter {

    /**
     * 支付渠道 详情转换
     *
     * @param payChannel 实体
     * @return 详情
     */
    PayChannelInfoVO info(PayChannel payChannel);

}