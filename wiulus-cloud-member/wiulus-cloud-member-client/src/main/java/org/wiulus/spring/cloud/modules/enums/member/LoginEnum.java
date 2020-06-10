package org.wiulus.spring.cloud.modules.enums.member;


/**
 * 注册类型枚举
 *
 * @author : WiuLuS 2019.5.12
 * @Version : 1.0
 */
public enum LoginEnum {

    /**
     * 手机注册
     */
    LOGIN_MOBILE(2),
    /**
     * 邮箱注册
     */
    LOGIN_EMAIL(1),
    /**
     * 用户名注册
     */
    LOGIN_MEMBERNAME(0);
    private int value;

    LoginEnum(int value){this.value = value;}

    public int value() {
        return this.value;
    }
}
