/**
 *
 *
 * https://www.wiulus.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.security.enums;

/**
 * 用户被踢出枚举
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
public enum UserKillEnum {
    YES(1),
    NO(0);

    private int value;

    UserKillEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
