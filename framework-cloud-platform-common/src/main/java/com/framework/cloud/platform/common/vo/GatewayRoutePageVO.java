package com.framework.cloud.platform.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 动态路由 分页VO
 *
 * @author wusiwei
 */
@Data
public class GatewayRoutePageVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "路由")
    private String path;

    @ApiModelProperty(value = "是否启用")
    private Boolean enable;
}