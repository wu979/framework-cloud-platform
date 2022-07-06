package com.framework.cloud.platform.common.vo;

import com.framework.cloud.common.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 动态路由 详情VO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GatewayRouteInfoVO extends BaseVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "路由")
    private String path;

    @ApiModelProperty(value = "断言")
    private String predicates;

    @ApiModelProperty(value = "过滤")
    private String filters;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "备注")
    private String remarks;
}