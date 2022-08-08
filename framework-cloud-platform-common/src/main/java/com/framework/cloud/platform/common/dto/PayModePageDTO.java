package com.framework.cloud.platform.common.dto;

import com.framework.cloud.common.base.BasePage;
import com.framework.cloud.platform.common.enums.PayModeType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付方式 分页DTO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayModePageDTO extends BasePage {

    @ApiModelProperty(value = "支付方式类型")
    private PayModeType modeType;

    @ApiModelProperty(value = "是否启用（0否1是）")
    private Boolean enable;

}