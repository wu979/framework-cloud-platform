package com.framework.cloud.platform.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 动态路由 快速新增DTO
 *
 * @author wusiwei
 */
@Data
public class GatewayFastRouteDTO {

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称")
    private String name;

    @NotBlank(message = "路由不能为空")
    @ApiModelProperty(value = "路由")
    private String path;

    @NotNull(message = "排序不能为空")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "是否启用")
    private Boolean enable;
}
