package com.framework.cloud.platform.common.vo;

import com.framework.cloud.common.base.BaseVO;
import com.framework.cloud.platform.common.enums.PayChannelType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付渠道 分页VO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayChannelPageVO extends BaseVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "标识")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "类型")
    private PayChannelType type;

    @ApiModelProperty(value = "是否启用（0否1是）")
    private Boolean enable;

}