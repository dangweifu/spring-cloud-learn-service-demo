/**
 *
 *
 * https://www.leimingtech.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.mybatis.annotation;

import java.lang.annotation.*;

/**
 * 数据过滤注解
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataFilter {
    /**
     * 表的别名
     */
    String tableAlias() default "";

    /**
     * 查询条件前缀，可选值有：[where、and]
     */
    String prefix() default "";

    /**
     * 用户ID
     */
    String userName() default "creator";

    /**
     * 部门ID
     */
    String deptId() default "dept_id";

}