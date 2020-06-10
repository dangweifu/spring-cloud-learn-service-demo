package org.wiulus.spring.cloud.modules.dto.invoice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.wiulus.spring.cloud.commons.tools.validator.group.UpdateGroup;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * @author : weixianchun
 * @Description : 用户发票信息管理(增值税)
 * @Date :2019/5/24 9:43
 * @Version V1.0
 **/
@Data
@ApiModel(description = "InvoiceDTO")
public class InvoiceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 索引id
     */
    @ApiModelProperty(value = "索引id")
    private Long id;

    /**
     * 会员ID
     */
    @NotBlank
    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    /**
     * 发票类型（1:普通发票，2:增值税发票，3:电子发票）
     */
    @ApiModelProperty(value = "发票类型（1:普通发票，2:增值税发票，3:电子发票）")
    private Integer invState;

    /**
     * 普通发票类型（1:个人发票，2:单位发票）
     */
    @ApiModelProperty(value = "普通发票类型（1:个人发票，2:单位发票）")
    private Integer invType;

    /**
     * 公司发票抬头名称
     */
    @NotBlank(message = "公司发票抬头名称不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "公司发票抬头名称")
    private String invCompany;

    /**
     * 个人发票抬头名称
     */
//    @NotBlank(message = "个人发票抬头名称不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "个人发票抬头名称")
    private String invPersonal;

    /**
     * 纳税人识别号
     */
    @NotBlank(message = "纳税人识别号不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "纳税人识别号")
    private String invCode;

    /**
     * 注册地址名称
     */
    @NotBlank(message = "注册地址名称不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "注册地址名称")
    private String invRegAddr;

    /**
     * 注册电话
     */
    @NotBlank(message = "注册电话不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "注册电话")
    private String invRegPhone;

    /**
     * 开户银行名称
     */
    @NotBlank(message = "开户银行名称不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "开户银行名称")
    private String invRegBname;

    /**
     * 银行帐户
     */
    @NotBlank(message = "银行帐户不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "银行帐户")
    private String invRegBaccount;

    /**
     * 收票人姓名
     */
    @NotBlank(message = "收票人姓名不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "收票人姓名")
    private String invRecName;

    /**
     * 收票人手机号
     */
    @NotBlank(message = "收票人手机号不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "收票人手机号")
    private String invRecMobile;

    /**
     * 收票人省市区ID（省市区ID中间使用ID分割）
     */
//    @NotBlank(message = "收票人省市区ID不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "收票人省市区ID（省市区ID中间使用ID分割）")
    private String invRecProvince;

    /**
     * 收票详细地址
     */
    @NotBlank(message = "收票详细地址不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "收票详细地址")
    private String invRecAddr;

    /**
     * 邮箱地址
     */
    @NotBlank(message = "邮箱地址不可为空", groups = UpdateGroup.class)
    @ApiModelProperty(value = "收票邮箱地址")
    private String invRecEmail;
    /**
     * 是否默认（默认0:否，1:是）
     */
    @ApiModelProperty(value = "是否默认（默认0:否，1:是）")
    private Integer isDefault;

    /**
     * 审核状态（0未审核，1审核通过，2审核未通过，3审核中）只有增值税专票需要审核
     */
    @ApiModelProperty(value = "审核状态（0未审核，1审核通过，2审核未通过，3审核中）只有增值税专票需要审核")
    private Integer auditStatus;

    /**
     * 删除标记（默认0:未删除,1:已删除）
     */
    @ApiModelProperty(value = "删除标记（默认0:未删除,1:已删除）")
    private Integer delFlag;

}