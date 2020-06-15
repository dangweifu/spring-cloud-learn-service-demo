package org.wiulus.spring.cloud.commons.tools.constant;

/**
 * @author : WiuLuS
 * @version : v1.0 06.08.2020
 * @discription : 正则表达式常量
 * @Date : 2020-06-08 15:57:50
 * @email : m13886933623@163.com
 */
public interface RegexConstant {

    /**
     * 登录账号校验正则表达式（满足a-z、A-Z、0-9、0-20位）
     */
    String LOGIN_ACCOUNT_REGEX = "^[a-zA-Z0-9_-]{0,20}$";
    /**
     * 登录密码校验
     */
    String LOGIN_PWD_REGEX ="^[a-zA-Z0-9_\\-*/=+`~()&^%$#@!<>?\\.;]{0,20}$";


    /**
     * 新增修改账号校验正则表达式（满足a-z、A-Z、0-9、6-20位）
     */
    String SAVE_UPDATE_ACCOUNT_REGEX = "^[a-zA-Z0-9_-]{6,20}$";

    /**
     * 新增修改密码校验正则表达式（满足a-z、A-Z、0-9、6-20位）
     */
    String SAVE_UPDATE_PWD_REGEX ="^[a-zA-Z0-9_\\-*/=+`~()&^%$#@!<>?\\.;]{6,20}$";

    /**
     * 新增修改手机号校验正则表达式（1开头,第二位是[3,4,5,6,7,8,9]中一位,满足11位）
     */
    String SAVE_UPDATE_PHONE_REGEX ="^1[3456789]\\d{9}$";
    /**
     * 新增修改邮箱校验正则表达式
     */
    String SAVE_UPDATE_EMAIL_REGEX ="[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";


}
