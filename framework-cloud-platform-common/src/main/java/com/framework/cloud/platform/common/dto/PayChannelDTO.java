package com.framework.cloud.platform.common.dto;

import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.platform.common.enums.PayChannelType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 支付渠道 新增修改DTO
 *
 * @author wusiwei
 */
@Data
public class PayChannelDTO {

    @Null(message = "新增时主键为空", groups = Save.class)
    @NotNull(message = "修改时主键不能为空", groups = Update.class)
    @ApiModelProperty(value = "主键")
    private Long id;

    @NotBlank(message = "标识不能为空")
    @ApiModelProperty(value = "标识")
    private String code;

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称")
    private String name;

    @NotNull(message = "类型不能为空")
    @ApiModelProperty(value = "类型")
    private PayChannelType type;

    @NotBlank(message = "账号不能为空")
    @ApiModelProperty(value = "账号")
    private String appKey;

    @NotBlank(message = "秘钥不能为空")
    @ApiModelProperty(value = "秘钥")
    private String appSecret;

    @NotBlank(message = "私钥不能为空")
    @ApiModelProperty(value = "私钥")
    private String privateKey;

    @NotBlank(message = "公钥不能为空")
    @ApiModelProperty(value = "公钥")
    private String publicKey;

    @NotBlank(message = "第三方公钥不能为空")
    @ApiModelProperty(value = "第三方公钥")
    private String externalPublicKey;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @NotNull(message = "是否启用不能为空")
    @ApiModelProperty(value = "是否启用（0否1是）")
    private Boolean enable;

}
