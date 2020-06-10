package org.wiulus.spring.cloud.modules.enums.member;

public enum HeadPortraitEnum {

    /**
     * 用户默认头像
     */
    MEMBER_HEADIMG("/group1/M00/00/04/wKgBbF0UX-SAYxbpAAKyM4Q0U_o788.png");

    private String value;

    HeadPortraitEnum(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
