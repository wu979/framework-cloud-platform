package com.framework.cloud.platform.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 授权码 新增DTO
 *
 * @author wusiwei
 */
@Data
public class OauthCodeDTO {

    @ApiModelProperty(value = "授权码")
    private String code;

    @ApiModelProperty(value = "授权用户信息")
    private byte[] authentication;

}
