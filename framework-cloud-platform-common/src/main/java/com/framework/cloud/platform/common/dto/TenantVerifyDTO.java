package com.framework.cloud.platform.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 租户审核 DTO
 *
 * @author wusiwei
 */
@Data
public class TenantVerifyDTO {

    @NotNull(message = "租户不能为空")
    @ApiModelProperty(value = "租户id")
    private Long tenantId;

    @NotNull(message = "是否通过不能为空")
    @ApiModelProperty(value = "是否通过")
    private Boolean isApproval;
}
