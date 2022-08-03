package com.framework.cloud.platform.common.msg;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 平台消息
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
public enum PlatformMsg {

    /** 异常消息 */
    TENANT_STATUS_UNUSUAL("租户状态异常"),
    TENANT_EXISTS("租户已存在"),
    OAUTH_CODE_NOT_EXISTS("授权码不存在"),
    GATEWAY_EXISTS("网关已存在"),
    GATEWAY_ENABLE("网关已启用，请勿重复操作"),
    GATEWAY_DISABLE("网关已禁用，请勿重复操作"),
    PUBLISH_GATEWAY_ROUTE_ERROR("动态网关发布事件失败"),
    ;

    private final String msg;
}
