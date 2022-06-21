package com.framework.cloud.platform.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 租户配置 实体
 *
 * @author wusiwei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_setting")
@ApiModel(value="租户配置对象", description="租户配置")
public class Setting {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "删除权限时是否删除后续节点	（是：删除后续子节点，更新其余节点左右值）	（否：删除当前节点，并更新当前节点左值+1节点的父级id，并且后续所有节点-2）")
    private Boolean permissionDelete;

    @ApiModelProperty(value = "租户id")
    private Long tenantId;
}