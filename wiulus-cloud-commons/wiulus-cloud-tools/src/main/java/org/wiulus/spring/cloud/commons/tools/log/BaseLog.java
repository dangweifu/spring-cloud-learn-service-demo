/**
 *
 *
 * https://www.leimingtech.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.log;

import lombok.Data;

import java.io.Serializable;

/**
 * Log基类
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
@Date
public abstract class BaseLog implements Serializable {
    /**
     * 日志类型
     */
    private Integer type;

}