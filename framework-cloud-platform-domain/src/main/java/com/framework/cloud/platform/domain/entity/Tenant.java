package com.framework.cloud.platform.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.framework.cloud.common.base.BaseEntity;
import com.framework.cloud.platform.common.enums.TenantStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 租户 实体
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_tenant")
@ApiModel(value="租户对象", description="租户")
public class Tenant extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "标识")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "秘钥")
    private String secret;

    @ApiModelProperty(value = "状态")
    private TenantStatus status;

    @ApiModelProperty(value = "单用户最大认证次数")
    private Integer maxCount;

    @ApiModelProperty(value = "重定向URI")
    private String redirectUri;

    @ApiModelProperty(value = "授权令牌的有效时间值(单位:秒)")
    private Integer accessTokenValidity;

    @ApiModelProperty(value = "刷新令牌的有效时间值(单位:秒)")
    private Integer refreshTokenValidity;

    @ApiModelProperty(value = "申请的权限范围")
    private String scope;

    @ApiModelProperty(value = "支持授权模式")
    private String grantType;

    @ApiModelProperty(value = "客户端所拥有的Spring Security的权限值")
    private String authorities;

    @ApiModelProperty(value = "设置用户是否自动Approval操作, 默认值为 'false', 可选值包括 'true','false', 'read','write'.")
    private String approve;

    @ApiModelProperty(value = "访问的资源id集合")
    private String resourceIds;

}