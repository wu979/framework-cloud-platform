package com.framework.cloud.platform.common.dto;

import com.framework.cloud.common.base.BasePage;
import com.framework.cloud.platform.common.enums.PayChannelType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付渠道 分页DTO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayChannelPageDTO extends BasePage {

    @ApiModelProperty(value = "标识")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "类型")
    private PayChannelType type;

    @ApiModelProperty(value = "是否启用（0否1是）")
    private Boolean enable;

}