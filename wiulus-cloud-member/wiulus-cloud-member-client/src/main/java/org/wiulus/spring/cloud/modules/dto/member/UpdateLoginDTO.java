/**
 * https://www.wiulus.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.modules.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 登录信息
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
@Data
@ApiModel(description = "UpdateLoginDTO")
public class UpdateLoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank(message = "{sysuser.username.require}")
    private String username;
    /**
     * 原密码
     */
    @ApiModelProperty(value = "原密码")
    private String oldPassword;
    /**
     * 新密码
     */
    @ApiModelProperty(value = "新密码")
    @NotBlank(message = "新密码不能为空")
    private String newPassword;
    /**
     * 确认密码
     */
    @ApiModelProperty(value = "确认密码")
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;


}
