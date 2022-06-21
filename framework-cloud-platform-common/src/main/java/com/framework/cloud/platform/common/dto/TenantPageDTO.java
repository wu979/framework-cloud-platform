package com.framework.cloud.platform.common.dto;

import com.framework.cloud.common.base.BasePage;
import com.framework.cloud.platform.common.enums.TenantStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 租户 分页DTO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TenantPageDTO extends BasePage {

    @ApiModelProperty(value = "租户标识")
    private String code;

    @ApiModelProperty(value = "租户名称")
    private String name;

    @ApiModelProperty(value = "租户状态")
    private TenantStatus status;
}