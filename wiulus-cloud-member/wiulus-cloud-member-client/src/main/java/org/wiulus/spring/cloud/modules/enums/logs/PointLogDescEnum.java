package org.wiulus.spring.cloud.modules.enums.logs;

/**
 * @Description  积分/成长值日志描述枚举
 * @author : WiuLuS
 * @Date 10:40 2019-12-25
 * @return
 */
public enum PointLogDescEnum {

    /**
     * 积分/成长值获取类型描述（1:新手欢迎奖励;2:设置头像;3:设置昵称;4:完善个人信息;
     * 5:首次关注店铺;6:首次分享商品;7:首次收藏商品;8:首次购物成功;9:首次完成评价;
     * 10:每日登录;11:每日签到;12:分享商品;13:邀请好友;14:好友首次下单成功;15:评价
     */
    WELCOME_SOURCE_DESC("新手欢迎奖励"),
    AVATAR_SOURCE_DESC("设置头像"),
    NICKNAME_SOURCE_DESC("设置昵称"),
    MEMBER_INFORMATION_SOURCE_DESC("完善个人信息"),
    ATTENTION_STORE_SOURCE_DESC("首次关注店铺"),
    FIRST_SHARE_GOODS_SOURCE_DESC("首次分享商品"),
    FAVORITES_GOODS_SOURCE_DESC("首次收藏商品"),
    FIRST_ORDER_SOURCE_DESC("首次购物成功"),
    FIRST_EVALUATE_ORDER_SOURCE_DESC("首次完成评价"),
    LOGIN_SOURCE_DESC("每日登录"),
    SIGNIN_SOURCE_DESC("每日签到"),
    SHARE_GOODS_SOURCE_DESC("分享商品"),
    INVITE_FRIENDS_SOURCE_DESC("邀请好友"),
    FRIEND_ORDER_SOURCE_DESC("好友首次下单成功"),
    EVALUATE_ORDER_SOURCE_DESC("评价"),
    MORE_RULES_SHOPPING_DESC("更多规则购物消费"),
    MORE_RULES_EVALUATE_DESC("更多规则商品评价"),
    REFUND_ORDER_DESC("退货进行积分成长值扣减")
    ;

    private String value;

    PointLogDescEnum(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
