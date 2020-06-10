/**
 *
 *
 * https://www.wiulus.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.modules.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 授权信息
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
@Data
@ApiModel(description = "AuthorizationDTO")
public class AuthorizationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "token", required = true)
    private String token;
    @ApiModelProperty(value = "过期时长，单位秒", required = true)
    private Integer expire;

}
