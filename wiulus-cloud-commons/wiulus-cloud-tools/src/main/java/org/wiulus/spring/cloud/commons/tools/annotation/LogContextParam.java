package org.wiulus.spring.cloud.commons.tools.annotation;

import java.lang.annotation.*;

/**
 * @Author: SWH ab4856812@163.com
 * @Description:
 * @Date: 2019/6/29 18:37
 * @Version: V1.0
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
