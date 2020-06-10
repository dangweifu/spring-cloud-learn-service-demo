package org.wiulus.spring.cloud.modules.entity.log;
import com.baomidou.mybatisplus.annotation.*;
import org.wiulus.spring.cloud.commons.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 用户登录日志表
 *
 * @author : WiuLuS
 * @email  1197793912@qq.com
 * @Version : 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("wls_shop_member_login_log")
public class MemberLoginLogEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
	private String loginName;

    /**
     * 用户ID
     */
	private Long memberId;

    /**
     * 操作ip
     */
	private String ip;

    /**
     * 用户代理
     */
	private String userAgent;

    /**
     * 登录地区
     */
	private String loginArea;

    /**
     * 登录方式   0:PC登录  1:手机  2:其他
     */
	private Integer source;

	/**
	 * 手机号
	 */
	private String phoneNumber;

	/**
	 * 登录状态   0：登录成功   1：登陆失败
	 */
	private Integer status;


	/**
     * 更新人
     */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updater;

    /**
     * 更新时间
     */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateDate;

    /**
     * 删除标记（默认为0未删除，1已删除）
     */
	@TableLogic
    @TableField(fill = FieldFill.INSERT)
	private Integer delFlag;

    /**
     * 乐观锁
     */
	@Version
	private Integer version;

}