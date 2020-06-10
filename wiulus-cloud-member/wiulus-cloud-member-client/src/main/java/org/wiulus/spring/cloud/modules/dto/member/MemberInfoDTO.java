package org.wiulus.spring.cloud.modules.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 会员详细信息表
 *
 * @author : WiuLuS
 * @email m13886933623@163.com
 * @Version : 1.0
 */
@Data
@ApiModel(description = "MemberInfoDTO")
public class MemberInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long memberId;
    /**
     * 支付密码
     */
    @ApiModelProperty(value = "支付密码")
    private String paymentPasswd;
    /**
     * 用户消费积分
     */
    @ApiModelProperty(value = "用户消费积分")
    private Integer consumePoint;
    /**
     * 用户可用积分
     */
    @ApiModelProperty(value = "用户可用积分")
    private Integer availablePoint;
    /**
     * 用户等级积分
     */
    @ApiModelProperty(value = "用户等级积分")
    private Integer gradePoint;

    /**
     * 用户等级
     */
    @ApiModelProperty(value = "用户等级")
    private String gradeName;
    /**
     * 地区ID
     */
    @ApiModelProperty(value = "地区ID")
    private String memberAreaId;
    /**
     * 城市ID
     */
    @ApiModelProperty(value = "城市ID")
    private String memberCityId;
    /**
     * 省份ID
     */
    @ApiModelProperty(value = "省份ID")
    private String memberProvinceId;
    /**
     * 街道ID
     */
    @ApiModelProperty(value = "街道ID")
    private String stressId;

    /**
     * 地区内容
     */
    @ApiModelProperty(value = "地区内容")
    private String memberAreainfo;
}