package org.wiulus.spring.cloud.modules.enums.logs;

/**
 * 积分/成长值日志枚举
 *
 * @author lixiang
 * @version V1.0
 * @date 2019/12/24 14:47
 **/
public enum PointLogEnum {

    /**
     * 类型 1积分 2成长值
     */
    POINT_TYPE(1),
    GROWTH_TYPE(2),

    /**
     * 积分/成长值获取类型（1:新手欢迎奖励;2:设置头像;3:设置昵称;4:完善个人信息;
     * 5:首次关注店铺;6:首次分享商品;7:首次收藏商品;8:首次购物成功;9:首次完成评价;
     * 10:每日登录;11:每日签到;12:分享商品;13:邀请好友;14:好友首次下单成功;15:评价
     */

    WELCOME_SOURCE_TYPE(1),
    AVATAR_SOURCE_TYPE(2),
    NICKNAME_SOURCE_TYPE(3),
    MEMBER_INFORMATION_SOURCE_TYPE(4),
    ATTENTION_STORE_SOURCE_TYPE(5),
    FIRST_SHARE_GOODS_SOURCE_TYPE(6),
    FAVORITES_GOODS_SOURCE_TYPE(7),
    FIRST_ORDER_SOURCE_TYPE(8),
    FIRST_EVALUATE_ORDER_SOURCE_TYPE(9),
    LOGIN_SOURCE_TYPE(10),
    SIGNIN_SOURCE_TYPE(11),
    SHARE_GOODS_SOURCE_TYPE(12),
    INVITE_FRIENDS_SOURCE_TYPE(13),
    FRIEND_ORDER_SOURCE_TYPE(14),
    EVALUATE_ORDER_SOURCE_TYPE(15),
    MORE_RULES_SHOPPING(16),
    MORE_RULES_EVALUATE(17),
    REFUND_ORDER(18),

    /**
     * 是否增加积分/成长值 0全部增加 1只增加积分 2只增加成长值
     */
    INSERT_ALL(0),
    INSERT_POINT(1),
    INSERT_GROWTH(2);

    private int value;

    PointLogEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
