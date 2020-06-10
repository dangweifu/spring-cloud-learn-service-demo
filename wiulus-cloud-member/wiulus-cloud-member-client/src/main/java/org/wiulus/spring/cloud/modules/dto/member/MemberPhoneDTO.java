package org.wiulus.spring.cloud.modules.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 会员表
 *
 * @author : WiuLuS
 * @email m13886933623@163.com
 * @Version : 1.0
 */
@Data
@ApiModel(description = "MemberPhoneDTO")
public class MemberPhoneDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickName;
    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    private String memberAvatar;

}