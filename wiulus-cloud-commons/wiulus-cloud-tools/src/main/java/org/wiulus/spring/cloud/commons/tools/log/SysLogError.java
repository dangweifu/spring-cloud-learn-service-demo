/**
 *
 *
 * https://www.wiulus.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.log;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 异常日志
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysLogError extends BaseLog {
	private static final long serialVersionUID = 1L;

	/**
	 * 模块名称，如：sys
	 */
	private String module;
	/**
	 * 请求URI
	 */
	private String requestUri;
	/**
	 * 请求方式
	 */
	private String requestMethod;
	/**
	 * 请求参数
	 */
	private String requestParams;
	/**
	 * 用户代理
	 */
	private String userAgent;
	/**
	 * 操作IP
	 */
	private String ip;
	/**
	 * 异常信息
	 */
	private String errorInfo;
	/**
	 * 创建者
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新者
	 */
	private String updater;

	/**
	 * 更新时间时间
	 */
	private Date updateDate;

}
