package org.wiulus.spring.cloud.modules.enums.grade;

/**
 * 用户等级枚举
 * DY 2019.5.10
 */
public enum MemberGradeEnum {
    /**
     * 是否是默认:非默认
     */
    DEFAULT_FLAG_DEFAULT(0),
    /**
     * 是否是默认:默认
     */
    DEFAULT_FLAG_UNDEFAULT(1);

    private int value;

    MemberGradeEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
