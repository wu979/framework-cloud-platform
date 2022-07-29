package com.framework.cloud.platform.common.enums;

import com.framework.cloud.swagger.annotation.SwaggerDisplayEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 授权模式类型
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
@SwaggerDisplayEnum(label = "grant")
public enum GrantType {

    /**
     * 授权码模式
     */
    AUTHORIZATION_CODE("authorization_code"),

    /**
     * 刷新模式
     */
    REFRESH_TOKEN("refresh_token"),

    /**
     * 客户端模式
     */
    CLIENT_CREDENTIALS("client_credentials"),

    /**
     * 密码模式
     */
    PASSWORD("password"),

    /**
     * 简化模式
     */
    IMPLICIT("implicit"),

    /**
     * 第三方模式
     */
    OPEN_ID("open_id");

    private final String grant;

    public static GrantType getGrantType(String grant) {
        for (GrantType type : GrantType.values()) {
            if (type.grant.equals(grant)) {
                return type;
            }
        }
        return null;
    }
}