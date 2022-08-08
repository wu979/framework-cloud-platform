package com.framework.cloud.platform.common.dto;

import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.platform.common.enums.PayModeType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * 支付方式 新增修改DTO
 *
 * @author wusiwei
 */
@Data
public class PayModeDTO {

    @Null(message = "新增时主键为空", groups = Save.class)
    @NotNull(message = "修改时主键不能为空", groups = Update.class)
    @ApiModelProperty(value = "主键")
    private Long id;

    @NotNull(message = "不能为空")
    @ApiModelProperty(value = "支付渠道id")
    private Long channelId;

    @ApiModelProperty(value = "直连商户号（微信）")
    private String mchId;

    @NotNull(message = "支付方式类型不能为空")
    @ApiModelProperty(value = "支付方式类型")
    private PayModeType modeType;

    @NotBlank(message = "支付方式版本号不能为空")
    @ApiModelProperty(value = "支付方式版本号")
    private String modeVersion;

    @NotBlank(message = "回调请求路径不能为空")
    @ApiModelProperty(value = "回调请求路径")
    private String notifyUrl;

    @ApiModelProperty(value = "支付后停留页面路径")
    private String returnUrl;

    @NotNull(message = "回调失败主动查询重试次数不能为空")
    @Min(value = 0, message = "回调失败主动查询重试次数区间（0 - 10）")
    @Max(value = 10, message = "回调失败主动查询重试次数区间（0 - 10）")
    @ApiModelProperty(value = "回调失败主动查询重试次数")
    private Integer retryCount;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @NotNull(message = "是否启用不能为空")
    @ApiModelProperty(value = "是否启用（0否1是）")
    private Boolean enable;

}