package org.wiulus.spring.cloud.modules.constant;

/**
 * <redis常量类>
 *
 * @author WiuLuS
 * @email m13886933623@163.com
 * @since 1.0 2019/7/18
 */
public class RedisConstants {

    private RedisConstants() {
    }

    /**
     * 注册手机验证码缓存前缀
     */
    public static final String REGISTER_MOBILE_CODE_PREFIX = "register_mobile_code:";

    /**
     * 店铺入住验证码
     */
    public static final String STORE_REGISTER_MOBILE_CODE_PREFIX = "store_register_mobile_code:";

    /**
     * 忘记密码验证码
     */
    public static final String STORE_FORGET_PWD_PREFIX = "store_forget_pwd_code:";
    /**
     * 登陆手机验证码缓存前缀
     */
    public static final String LOGIN_MOBILE_CODE_PREFIX = "login_mobile_code:";

    /**
     * 修改密码手机验证码缓存前缀
     */
    public static final String UPDATE_PWD_MOBILE_CODE_PREFIX = "update_pwd_mobile_code:";

}
