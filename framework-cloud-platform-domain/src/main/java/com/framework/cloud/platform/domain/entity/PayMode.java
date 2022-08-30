package com.framework.cloud.platform.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.framework.cloud.common.base.BaseEntity;
import com.framework.cloud.enums.platform.PayModeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 支付方式 实体
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_pay_mode")
@ApiModel(value = "支付方式对象", description = "支付方式")
public class PayMode extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
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