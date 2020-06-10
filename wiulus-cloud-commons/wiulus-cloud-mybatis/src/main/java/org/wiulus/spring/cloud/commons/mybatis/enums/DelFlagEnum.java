/**
 *
 *
 * https://www.wiulus.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.mybatis.enums;

/**
 * 删除标识枚举类
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
public enum DelFlagEnum {
    NORMAL(0),
    DEL(1);

    private int value;

    DelFlagEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
