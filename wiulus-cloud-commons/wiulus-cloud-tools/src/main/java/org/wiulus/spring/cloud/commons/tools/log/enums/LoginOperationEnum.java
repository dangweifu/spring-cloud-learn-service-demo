/**
 *
 *
 * https://www.wiulus.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.log.enums;

/**
 * 登录操作枚举
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
public enum LoginOperationEnum {
    /**
     * 用户登录
     */
    LOGIN(0),
    /**
     * 用户退出
     */
    LOGOUT(1);

    private int value;

    LoginOperationEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}