/**
 *
 *
 * https://www.leimingtech.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.log;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 登录日志
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
@Date
@EqualsAndHashCode(callSuper=false)
public class SysLogLogin extends BaseLog {
    private static final long serialVersionUID = 1L;
	/**
	 * 用户操作   0：用户登录   1：用户退出
	 */
	private Integer operation;
	/**
	 * 状态  0：失败    1：成功    2：账号已锁定
	 */
	private Integer status;
	/**
	 * 用户代理
	 */
	private String userAgent;
	/**
	 * 操作IP
	 */
	private String ip;

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