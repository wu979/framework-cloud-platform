package com.framework.cloud.platform.common.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 租户状态
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TenantStatus implements IEnum<String> {

    /** code 第三方枚举 value 数据库 label 汉译 */
    REVIEWED(0, "待审核"),
    REVIEW(1, "审核中"),
    NORMAL(2, "正常"),
    CANCELLATION(3, "注销"),
    DISABLE(4, "禁用"),
    REFUSE(5, "审核拒绝"),
    ;

    private final int code;
    private final String label;

    @Override
    public String getValue() {
        return this.name();
    }

}
