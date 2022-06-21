package com.framework.cloud.platform.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 租户配置 详情VO
 *
 * @author wusiwei
 */
@Data
public class SettingInfoVO {

    @ApiModelProperty(value = "删除权限时是否删除后续节点	（是：删除后续子节点，更新其余节点左右值）	（否：删除当前节点，并更新当前节点左值+1节点的父级id，并且后续所有节点-2）")
    private Boolean permissionDelete;

}