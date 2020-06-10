//package org.wiulus.spring.cloud.modules.code;
//
//import org.wiulus.spring.cloud.exception.ServiceStatusCode;
//
///**
// * MemberStatusCode
// * @Description 会员模块日志码
// * @author : WiuLuS
// * @Date 2019/7/3 15:04
// * @Version 1.0
// */
//
//public class MemberStatusCode extends ServiceStatusCode {
//
//    //会员管理列表查询成功
//    public static final String ADMIN_MEMBER_PAGE_SUCCESS_CODE = "2001001";
//    public static final String ADMIN_MEMBER_PAGE_SUCCESS_MSG = "会员列表分页查询成功";
//
//    //会员管理列表查询成功(站内信)
//    public static final String ADMIN_MEMBER_MESSAGE_PAGE_SUCCESS_CODE = "2001002";
//    public static final String ADMIN_MEMBER_MESSAGE_PAGE_SUCCESS_MSG = "站内信会员列表分页查询成功";
//
//    // 会员详情查询成功
//    public static final String ADMIN_MEMBER_DETAILS_SUCCESS_CODE = "2001003";
//    public static final String ADMIN_MEMBER_DETAILS_SUCCESS_msg = "会员详情查询成功";
//
//    //会员信息保存成功
//    public static final String ADMIN_MEMBER_SAVE_SUCCESS_CODE = "2001004";
//    public static final String ADMIN_MEMBER_SAVE_SUCCESS_MSG = "会员信息保存成功";
//
//    // 会员信息修改成功
//    public static final String ADMIN_MEMBER_UPDATE_SUCCESS_CODE = "2001005";
//    public static final String ADMIN_MEMBER_UPDATE_SUCCESS_MSG = "会员信息修改成功";
//
//    //  会员编辑信息查询成功
//    public static final String ADMIN_MEMBER_EDIT_SUCCESS_CODE = "2001006";
//    public static final String ADMIN_MEMBER_EDIT_SUCCESS_MSG = "会员编辑信息查询成功";
//
//    //会员信息删除成功
//    public static final String ADMIN_MEMBER_DEL_SUCCESS_CODE = "2001007";
//    public static final String ADMIN_MEMBER_DEL_SUCCESS_MSG = "会员信息删除成功";
//
//
//    //会员密码重置成功
//    public static final String ADMIN_MEMBER_RESET_PWD_SUCCESS_CODE = "2001008";
//    public static final String ADMIN_MEMBER_RESET_PWD_SUCCESS_MSG = "重置密码成功";
//
//    //修改用户状态
//    public static final String ADMIN_MEMBER_STATE_SUCCESS_CODE = "2001009";
//    public static final String ADMIN_MEMBER_STATE_SUCCESS_MSG = "修改用户状态成功";
//
//    //获取微信openid
//    public static final String MEMBER_WXOPENID_SUCCESS_CODE = "200001";
//    public static final String MEMBER_WXOPENID_SUCCESS_MSG = "获取微信openid";
//
//    //修改密码
//    public static final ServiceStatusCode ORDER_CHANGE_SHOW_STATUS_EXCERTION = new MemberStatusCode("400101", "两次输入密码不一致");
//
//    // 获取微信信息失败
//    public static final ServiceStatusCode GET_WECHAT_OPENID_ERROR = new ServiceStatusCode
//            .InternalServiceStatusCode("500501", "获取微信信息失败", new Object[0]);
//
//    // 开始进行用户的积分封装
//    public static final String COMPUTE_MEMBER_POINT_CODE = "200002";
//    public static final String COMPUTE_MEMBER_POINT_CODE_MSG = "开始进行用户的积分封装";
//
//    // 用户最终的积分
//    public static final String FINAL_COMPUTE_MEMBER_POINT_CODE = "200003";
//    public static final String FINAL_COMPUTE_MEMBER_POINT_CODE_MSG = "用户最终的积分";
//
//    protected MemberStatusCode(String code, String message, Object... arguments) {
//        super(code, message, arguments);
//    }
//
//    @Override
//    public ServiceStatusCode copy(String var1, Object... var2) {
//        return null;
//    }
//}
