package com.framework.cloud.platform.common.vo;

import com.framework.cloud.platform.common.enums.TenantStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 租户 分页VO
 *
 * @author wusiwei
 */
@Data
public class TenantPageVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "标识")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "状态")
    private TenantStatus status;

}