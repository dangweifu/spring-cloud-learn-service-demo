package org.wiulus.spring.cloud.modules.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MobileUtil
 * @Description 手机号验证工具类
 * @author : WiuLuS
 * @Date 2019/5/15 19:22
 * @Version 1.0
 **/
public class MobileUtil {

    private MobileUtil() {
    }

    /**
     * 手机号格式验证
     *
     * @param phone
     * @return
     */
    public static boolean isMobile(String phone) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$"); // 验证手机号
        m = p.matcher(phone);
        b = m.matches();
        return b;
    }
}
