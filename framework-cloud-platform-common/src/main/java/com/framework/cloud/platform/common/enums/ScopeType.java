package com.framework.cloud.platform.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 授权范围类型
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
public enum ScopeType {

    /** 全部 */
    ALL("all"),

    ;

    private final String scope;

    public static ScopeType getScopeType(String scope) {
        for (ScopeType type : ScopeType.values()) {
            if (type.scope.equals(scope)) {
                return type;
            }
        }
        return null;
    }
}
