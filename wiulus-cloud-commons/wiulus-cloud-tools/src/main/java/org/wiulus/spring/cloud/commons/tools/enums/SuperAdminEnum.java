/**
 *
 *
 * https://www.wiulus.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.enums;

/**
 * 超级管理员枚举
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
public enum SuperAdminEnum {
    /**
     * 超级管理员枚举
     */
    YES(1),
    NO(0);

    private int value;

    SuperAdminEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}