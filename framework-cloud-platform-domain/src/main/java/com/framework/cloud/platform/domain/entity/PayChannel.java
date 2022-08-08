package com.framework.cloud.platform.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.framework.cloud.common.base.BaseEntity;
import com.framework.cloud.platform.common.enums.PayChannelType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 支付渠道 实体
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_pay_channel")
@ApiModel(value="支付渠道对象", description="支付渠道")
public class PayChannel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "标识")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "类型")
    private PayChannelType type;

    @ApiModelProperty(value = "账号")
    private String appKey;

    @ApiModelProperty(value = "秘钥")
    private String appSecret;

    @ApiModelProperty(value = "私钥")
    private String privateKey;

    @ApiModelProperty(value = "公钥")
    private String publicKey;

    @ApiModelProperty(value = "第三方公钥")
    private String externalPublicKey;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "是否启用（0否1是）")
    private Boolean enable;

}