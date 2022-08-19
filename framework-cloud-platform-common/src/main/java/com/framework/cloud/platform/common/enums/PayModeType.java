package com.framework.cloud.platform.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.framework.cloud.common.base.BaseEnum;
import com.framework.cloud.swagger.annotation.SwaggerDisplayEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付方式
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@SwaggerDisplayEnum
public enum PayModeType implements BaseEnum<String> {

    /** code 第三方枚举 value 数据库 label 汉译 */
    WX_APP(0, "微信唤醒支付"),
    WX_JSAPI(1, "微信JSAPI支付"),
    WX_NATIVE(2, "微信扫码支付"),
    WX_APPLET(3, "微信小程序支付"),
    WX_PAYMENT(4, "微信付款码支付"),

    ZFB_APP(5, "支付宝唤醒支付"),
    ZFB_MOBILE(5, "支付宝手机网站支付"),
    ZFB_COMPUTER(5, "支付宝电脑网站支付"),
    ZFB_FACE(5, "支付宝刷脸支付"),
    ZFB_NATIVE(5, "支付宝扫码支付"),
    ZFB_PAYMENT(5, "支付宝付款码支付"),

    YL_CARD(5, "银联银行卡支付")
    ;

    private final int code;
    private final String label;

    @Override
    public String getValue() {
        return this.name();
    }
}
