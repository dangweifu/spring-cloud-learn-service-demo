/**
 *
 *
 * https://www.wiulus.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.log;

import lombok.Data;

import java.io.Serializable;

/**
 * Log基类
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
@Data
public abstract class BaseLog implements Serializable {
    /**
     * 日志类型
     */
    private Integer type;

}