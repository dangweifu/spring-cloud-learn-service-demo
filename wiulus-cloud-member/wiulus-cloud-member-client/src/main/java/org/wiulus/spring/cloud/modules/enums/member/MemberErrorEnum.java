package org.wiulus.spring.cloud.modules.enums.member;

/**
 * 用户错误信息枚举
 */
public enum MemberErrorEnum {

    /**
     * 用户错误信息枚举
     */
    E_CAPTCHA_PASS(1001, "验证码已过期"),

    E_CAPTCHA_ERROR(1002, "验证码错误"),

    E_MOBILE_ERROR(1003, "手机号格式不正确"),

    E_MOBILE_REGISTERED(1003, "手机号已被注册"),

    E_EMAIL_ERROR(1004, "邮箱不能为空"),

    E_EMAIL_REGISTERED(1005, "邮箱已被注册"),

    E_LOGIN_TYPE(1006, "请重新填写注册类型"),

    E_CAPTCHA_SUCCESS(1007, "验证码已发送"),

    E_CAPTCHA_AGAIN(1008, "验证码已发送,请稍后重试"),

    E_WECHAT_ACCESSTOKEN_ERROR(1009, "获取accessToken失败"),

    E_USERLOGIN_CODE_ERROR(401, "security用户名空,没有认证"),

    E_WECHAT_CODE_ERROR(1010, "code不能为空"),

    E_IS_NULL(1011, "用户不存在"),

    E_MOBILE_IS_NULL(1012, "未使用手机号注册"),

    E_MOBILE_IS_EXIT(1020, "该号码已注册"),

    E_MESSAGE_SMS_IS_NULL(1013, "发送失败，短信验证码未开启"),

    E_REGISTER_SUCCESS(200, "校验通过"),

    E_WECHAT_MOBILE_UNBIND(1017, "微信登录失败，未绑定会员手机号"),

    E_WECHAT_BIND_ACCESS_EXCERTION(1015, "当前手机账户已被禁止使用"),

    E_WECHAT_BINDED_MOBILE(1016, "该手机账号已绑定第三方平台"),

    E_WECHAT_MOBILE_FAIL(1018, "获取微信授权失败"),

    E_REGISTER_FAILED(1014, "注册失败，请联系管理员");



    private String value;
    private int code;

    MemberErrorEnum(int code, String value) {
        this.value = value;
        this.code = code;
    }

    public String value() {
        return this.value;
    }

    public int code() {
        return this.code;
    }
}
