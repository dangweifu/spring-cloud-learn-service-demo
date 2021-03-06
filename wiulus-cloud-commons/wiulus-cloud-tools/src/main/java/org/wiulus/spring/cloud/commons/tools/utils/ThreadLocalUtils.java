package org.wiulus.spring.cloud.commons.tools.utils;


import org.wiulus.spring.cloud.commons.tools.annotation.LogContext;
import org.wiulus.spring.cloud.commons.tools.annotation.LogContextParam;

/**
 * @author : WiuLuS m13886933623@163.com
 * @Description :
 * @Date : 2019/6/29 18:54
 * @version : V1.0
 */
public class ThreadLocalUtils {

    private ThreadLocalUtils() {
    }

    /**
     * 声明一个上下文线程本地变量
     **/
    public static final ThreadLocal<LogContext> logContextThreadLocal = new ThreadLocal<>();

    /**
     * 声明一个sdk业务参数本地变量
     **/
    public static final ThreadLocal<LogContextParam> logContextServiceParamThreadLocal = new ThreadLocal<>();
}
