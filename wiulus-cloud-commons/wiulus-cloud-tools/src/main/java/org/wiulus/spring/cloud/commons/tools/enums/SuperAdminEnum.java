/**
 *
 *
 * https://www.leimingtech.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.enums;

/**
 * 超级管理员枚举
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
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