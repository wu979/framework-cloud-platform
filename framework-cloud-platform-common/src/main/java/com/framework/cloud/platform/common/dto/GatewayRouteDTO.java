package com.framework.cloud.platform.common.dto;

import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 动态路由 新增修改DTO
 *
 * @author wusiwei
 */
@Data
public class GatewayRouteDTO {

    @Null(message = "新增时主键为空", groups = Save.class)
    @NotNull(message = "修改时主键不能为空", groups = Update.class)
    @ApiModelProperty(value = "主键")
    private Long id;

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称")
    private String name;

    @NotBlank(message = "路由不能为空")
    @ApiModelProperty(value = "路由")
    private String path;

    @NotBlank(message = "断言不能为空")
    @ApiModelProperty(value = "断言")
    private String predicates;

    @NotBlank(message = "过滤不能为空")
    @ApiModelProperty(value = "过滤")
    private String filters;

    @NotNull(message = "排序不能为空")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
