package com.framework.cloud.platform.infrastructure.converter;

import com.framework.cloud.platform.common.vo.PayModeInfoVO;
import com.framework.cloud.platform.common.vo.PayModeListVO;
import com.framework.cloud.platform.domain.entity.PayMode;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 支付方式 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface PayModeConverter {

    /**
     * 支付方式 详情转换
     *
     * @param payMode 实体
     * @return 详情
     */
    PayModeInfoVO info(PayMode payMode);

    /**
     * 支付方式 列表转换
     *
     * @param payModeList 实体列表
     * @return 详情
     */
    List<PayModeListVO> list(List<PayMode> payModeList);
}