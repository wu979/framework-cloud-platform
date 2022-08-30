package com.framework.cloud.platform.common.constant;

/**
 * @author wusiwei
 */
public class PlatformConstant {

    /**
     * 租户缓存
     */
    public static final String TENANT = "tenant:";

    /**
     * 支付渠道缓存
     */
    public static final String CHANNEL = "pay:channel:";

    /**
     * 支付方式缓存
     */
    public static final String MODE = "pay:mode:";

    /**
     * 缓存时间
     */
    public static final long TENANT_TIME = 7200;

    /**
     * 服务前缀
     */
    public static final String LB = "lb://";

    /**
     * 服务断言
     */
    public static final String PREDICATES_ARGS = "/api/{0}/**";

    /**
     * 服务断言名称
     */
    public static final String PREDICATES_NAME = "Path";

    /**
     * 服务过滤
     */
    public static final String FILTER_ARGS = "2";

    /**
     * 服务过滤名称
     */
    public static final String FILTER_NAME = "StripPrefix";
}
