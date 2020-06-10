package org.wiulus.spring.cloud.modules.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.wiulus.spring.cloud.commons.tools.validator.group.UpdateGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * @Description 会员修改实体
 * @author :DY
 * @Date 2019/5/15 17:26
 * @Version 1.0
 **/
@Data
@ApiModel(description = "MemberUpdateDTO")
public class MemberUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "用户ID")
    @NotNull(message = "{id.require}", groups = UpdateGroup.class)
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String memberName;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    @Null(message = "昵称不可修改", groups = UpdateGroup.class)
    private String nickName;
    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    @NotBlank(message = "{sysuser.password.require}")
    private String memberPasswd;

    /**
     * 省份ID
     */
    @ApiModelProperty(value = "省份ID")
    private String memberProvinceId;

    /**
     * 城市ID
     */
    @ApiModelProperty(value = "城市ID")
    private String memberCityId;

    /**
     * 地区ID
     */
    @ApiModelProperty(value = "地区ID")
    private String memberAreaId;

    /**
     * 街道ID
     */
    @ApiModelProperty(value = "街道ID")
    private String stressId;

    @ApiModelProperty(value = "用户可用积分")
    private Integer availablePoint;

    @ApiModelProperty(value = "用户等级积分")
    private Integer gradePoint;
}
