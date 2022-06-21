package com.framework.cloud.platform.common.vo;

import com.framework.cloud.common.base.BaseVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.platform.common.enums.ApproveType;
import com.framework.cloud.platform.common.enums.GrantType;
import com.framework.cloud.platform.common.enums.ScopeType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Null;
import java.util.Set;

/**
 * 租户 详情VO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TenantInfoVO extends BaseVO {

    @Null(message = "新增时主键为空", groups = Save.class)
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "标识")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "秘钥")
    private String secret;

    @ApiModelProperty(value = "重定向URI")
    private String redirectUri;

    @ApiModelProperty(value = "授权令牌的有效时间值(单位:秒)")
    private Integer accessTokenValidity;

    @ApiModelProperty(value = "刷新令牌的有效时间值(单位:秒)")
    private Integer refreshTokenValidity;

    @ApiModelProperty(value = "申请的权限范围")
    private Set<ScopeType> scope;

    @ApiModelProperty(value = "支持授权模式")
    private Set<GrantType> grantType;

    @ApiModelProperty(value = "客户端所拥有的Spring Security的权限值")
    private Set<String> authorities;

    @ApiModelProperty(value = "设置用户是否自动Approval操作, 默认值为 'false', 可选值包括 'true','false', 'read','write'.")
    private Set<ApproveType> approve;

    @ApiModelProperty(value = "访问的资源id集合")
    private Set<String> resourceIds;

}