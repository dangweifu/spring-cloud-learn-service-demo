package org.wiulus.spring.cloud.modules.dto.log;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.wiulus.spring.cloud.commons.tools.validator.group.AddGroup;
import org.wiulus.spring.cloud.commons.tools.validator.group.UpdateGroup;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户登录日志表
 *
 * @author : WiuLuS
 * @email m13886933623@163.com
 * @Version : 1.0
 */
@Data
@ApiModel(description = "MemberLoginLogDTO")
public class MemberLoginLogDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String loginName;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long memberId;

    /**
     * 操作ip
     */
    @ApiModelProperty(value = "操作ip")
    private String ip;

    /**
     * 用户代理
     */
    @ApiModelProperty(value = "用户代理")
    private String userAgent;

    /**
     * 登录地区
     */
    @ApiModelProperty(value = "登录地区")
    private String loginArea;

    /**
     * 登录方式   0:PC登录  1:手机  2:其他
     */
    @ApiModelProperty(value = "登录方式   0:PC登录  1:手机  2:其他")
    private Integer source;

    /**
     * 手机号
     */
    @Length(max = 11, message = "手机号只能为11位", groups = AddGroup.class)
    @Length(max = 11, message = "手机号只能为11位", groups = UpdateGroup.class)
    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    /**
     * 登录状态   0：登录成功   1：登陆失败
     */
    @ApiModelProperty(value = "登录状态   0：登录成功   1：登陆失败")
    private Integer status;
    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private Date createDate;

}