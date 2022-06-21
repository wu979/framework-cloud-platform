package com.framework.cloud.platform.common.dto;

import com.framework.cloud.common.enums.GlobalNumber;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.platform.common.enums.ApproveType;
import com.framework.cloud.platform.common.enums.GrantType;
import com.framework.cloud.platform.common.enums.ScopeType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 租户 新增修改DTO
 *
 * @author wusiwei
 */
@Data
public class TenantDTO {

    @Null(message = "新增时主键为空", groups = Save.class)
    @NotNull(message = "修改时主键不能为空", groups = Update.class)
    @ApiModelProperty(value = "主键")
    private Long id;

    @NotBlank(message = "标识不能为空")
    @ApiModelProperty(value = "标识")
    private String code;

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称")
    private String name;

    @NotBlank(message = "秘钥不能为空")
    @ApiModelProperty(value = "秘钥")
    private String secret;

    @NotBlank(message = "重定向URI不能为空")
    @ApiModelProperty(value = "重定向URI")
    private String redirectUri;

    @NotNull(message = "令牌时效是否无限制不能为空")
    @ApiModelProperty(value = "令牌是否无限制")
    private Boolean unlimited;

    @ApiModelProperty(value = "授权令牌的有效时间值(单位:秒)")
    private Integer accessTokenValidity;

    @ApiModelProperty(value = "刷新令牌的有效时间值(单位:秒)")
    private Integer refreshTokenValidity;

    @ApiModelProperty(value = "申请的权限范围")
    private Set<ScopeType> scopeList = new HashSet<>();

    @Size(min = 1, message = "授权模式不能为空")
    @ApiModelProperty(value = "支持的授权模式")
    private Set<GrantType> grantTypeList;

    @ApiModelProperty(value = "客户端所拥有的Spring Security的权限值")
    private Set<String> authoritieList = new HashSet<>();

    @ApiModelProperty(value = "设置用户是否自动批准操作, 默认值为 'false', 可选值包括 'true','false', 'read','write'.")
    private Set<ApproveType> approveList = new HashSet<>();

    @ApiModelProperty(value = "访问的资源id集合")
    private Set<String> resourceIdList = new HashSet<>();

    @AssertTrue(message = "令牌时效输入错误")
    private boolean isUnlimited() {
        //最小半个小时 最大一个月
        final int minTime = 1800, maxTime = 2626560;
        if (unlimited) {
            GlobalNumber minusOne = GlobalNumber.MINUS_ONE;
            return minusOne.getIntValue().equals(accessTokenValidity) && minusOne.getIntValue().equals(refreshTokenValidity);
        }
        if (accessTokenValidity == null || refreshTokenValidity == null) {
            return false;
        }
        if (accessTokenValidity < minTime || accessTokenValidity > maxTime) {
            return false;
        }
        if (refreshTokenValidity < minTime || refreshTokenValidity > maxTime) {
            return false;
        }
        return true;
    }
}
