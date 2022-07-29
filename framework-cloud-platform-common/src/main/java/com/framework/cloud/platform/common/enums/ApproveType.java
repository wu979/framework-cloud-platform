package com.framework.cloud.platform.common.enums;

import com.framework.cloud.swagger.annotation.SwaggerDisplayEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 允许用户批准操作类型
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
@SwaggerDisplayEnum(label = "approve")
public enum ApproveType {

    /** 不允许 */
    FALSE("false"),
    /** 允许 */
    TRUE("true"),
    /** 读 */
    READ("read"),
    /** 写 */
    WRITE("write"),
    ;

    private final String approve;

    public static ApproveType getApproveType(String approve) {
        for (ApproveType type : ApproveType.values()) {
            if (type.approve.equals(approve)) {
                return type;
            }
        }
        return null;
    }
}
