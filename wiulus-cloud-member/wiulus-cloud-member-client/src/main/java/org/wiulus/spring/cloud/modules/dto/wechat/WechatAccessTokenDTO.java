package org.wiulus.spring.cloud.modules.dto.wechat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.wiulus.spring.cloud.commons.tools.validator.group.AddGroup;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <微信通过code获取access_token实体>
 *
 * @author WiuLuS
 * @email m13886933623@163.com
 */
@Data
@ApiModel(description = "WechatAccessTokenDTO")
public class WechatAccessTokenDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("网页授权接口调用凭证")
    @NotBlank(message = "授权凭证不能为空", groups = AddGroup.class)
    private String accessToken;

    @ApiModelProperty("accessToken 接口调用凭证超时时间，单位（秒）")
    private String expiresIn;

    @ApiModelProperty("用户刷新 accessToken")
    private String refreshToken;

    @ApiModelProperty("授权用户唯一标识")
    @NotBlank(message = "openid不能为空", groups = AddGroup.class)
    private String openid;

    @ApiModelProperty("用户授权作用域，用(,)隔开")
    private String scope;

    @ApiModelProperty("当且仅当网站已获得用户的userinfo授权时，才会出现该字段")
    @NotBlank(message = "unionId", groups = AddGroup.class)
    private String unionId;
}
