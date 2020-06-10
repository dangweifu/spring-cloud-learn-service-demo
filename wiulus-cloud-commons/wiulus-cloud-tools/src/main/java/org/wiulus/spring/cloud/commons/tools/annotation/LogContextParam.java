package org.wiulus.spring.cloud.commons.tools.annotation;

import java.lang.annotation.*;

/**
 * @author : WiuLuS m13886933623@163.com
 * @Description :
 * @Date : 2019/6/29 18:37
 * @version : V1.0
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogContextParam {

    /**
     *
     * @return
     */
    String name() default "";
}
