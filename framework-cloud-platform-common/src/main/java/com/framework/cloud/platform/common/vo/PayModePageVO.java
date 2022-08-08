package com.framework.cloud.platform.common.vo;

import com.framework.cloud.common.base.BaseVO;
import com.framework.cloud.platform.common.enums.PayModeType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付方式 分页VO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayModePageVO extends BaseVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "支付渠道id")
    private Long channelId;

    @ApiModelProperty(value = "直连商户号（微信）")
    private String mchId;

    @ApiModelProperty(value = "支付方式类型")
    private PayModeType modeType;

    @ApiModelProperty(value = "支付方式版本号")
    private String modeVersion;

    @ApiModelProperty(value = "回调请求路径")
    private String notifyUrl;

    @ApiModelProperty(value = "支付后停留页面路径")
    private String returnUrl;

    @ApiModelProperty(value = "回调失败主动查询重试次数")
    private Integer retryCount;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "是否启用（0否1是）")
    private Boolean enable;

}