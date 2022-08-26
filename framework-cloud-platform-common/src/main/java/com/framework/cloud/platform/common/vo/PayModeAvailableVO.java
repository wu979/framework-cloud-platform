package com.framework.cloud.platform.common.vo;

import cn.hutool.core.codec.Base64;
import com.framework.cloud.enums.platform.PayChannelType;
import com.framework.cloud.enums.platform.PayModeType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 支付方式 可用列表VO
 *
 * @author wusiwei
 */
@Data
public class PayModeAvailableVO {

    @ApiModelProperty(value = "支付渠道")
    private Long channelId;

    @ApiModelProperty(value = "支付渠道名称")
    private String channelName;

    @ApiModelProperty(value = "支付渠道类型")
    private PayChannelType channelType;

    @ApiModelProperty(value = "私钥")
    private String privateKey;

    @ApiModelProperty(value = "支付方式")
    private Long modeId;

    @ApiModelProperty(value = "支付方式类型")
    private PayModeType modeType;

    public void setPrivateKey(String privateKey) {
        this.privateKey = Base64.encode(privateKey);
    }
}
