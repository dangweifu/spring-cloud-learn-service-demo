package org.wiulus.spring.cloud.modules.enums.member;

/**
 * @author: WiuLuS m13886933623@163.com
 * @Description : 会员地址枚举类
 * @Date: 16:53 2019/6/14
 * @Version : V1.0
 */
public enum MemberAddressEnum {

    /**
     * 用户非默认地址标识
     */
    IS_NOT_DEFAULT(0),

    /**
     * 用户默认地址标识
     */
    IS_DEFAULT(1);

    private int value;

    MemberAddressEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
