package org.wiulus.spring.cloud.commons.tools.annotation;

import java.lang.annotation.*;

/**
 * @author : WiuLuS m13886933623@163.com
 * @Description :
 * @Date : 2019/6/29 18:37
 * @version : V1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogContext {

    /**
     * 状态码 默认为空字符串
     **/
    String code() default "";

    /**
     * 状态描述 默认为空字符串
     **/
    String note() default "";
}
