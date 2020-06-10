package org.wiulus.spring.cloud.modules.dto.invoice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.wiulus.spring.cloud.commons.tools.validator.group.AddGroup;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * @author : weixianchun
 * @Description : 用户发票信息管理(保存增值税发票用)
 * @Date :2019/5/24 9:40
 * @Version V1.0
 **/
@Data
@ApiModel(description = "InvoiceSaveDTO")
public class InvoiceSaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 会员ID
     */
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
    @NotBlank(message = "公司发票抬头名称不可为空", groups = AddGroup.class)
    @Length(max = 100, message = "公司发票抬头长度必须介于0和100之间", groups = AddGroup.class)
    @ApiModelProperty(value = "公司发票抬头名称")
    private String invCompany;

    /**
     * 个人发票抬头名称
     */
//    @NotBlank(message = "个人发票抬头名称不可为空", groups = AddGroup.class)
    @Length(max = 100, message = "个人发票抬头长度必须介于0和100之间", groups = AddGroup.class)
    @ApiModelProperty(value = "个人发票抬头名称")
    private String invPersonal;

    /**
     * 纳税人识别号
     */
    @NotBlank(message = "纳税人识别号不可为空", groups = AddGroup.class)
    @ApiModelProperty(value = "纳税人识别号")
    private String invCode;

    /**
     * 注册地址名称
     */
    @NotBlank(message = "注册地址名称不可为空", groups = AddGroup.class)
    @Length(max = 100, message = "收票人姓名长度必须介于0和100之间", groups = AddGroup.class)
    @ApiModelProperty(value = "注册地址名称")
    private String invRegAddr;

    /**
     * 注册电话
     */
    @NotBlank(message = "注册电话不可为空", groups = AddGroup.class)
    @Length(max = 100, message = "收票人姓名长度必须介于0和100之间", groups = AddGroup.class)
    @ApiModelProperty(value = "注册电话")
    private String invRegPhone;

    /**
     * 开户银行名称
     */
    @NotBlank(message = "开户银行名称不可为空", groups = AddGroup.class)
    @ApiModelProperty(value = "开户银行名称")
    private String invRegBname;

    /**
     * 银行帐户
     */
    @NotBlank(message = "银行帐户不可为空", groups = AddGroup.class)
    @ApiModelProperty(value = "银行帐户")
    private String invRegBaccount;

    /**
     * 收票人姓名
     */
    @NotBlank(message = "收票人姓名不可为空", groups = AddGroup.class)
    @Length(max = 10, message = "收票人姓名长度必须介于0和10之间", groups = AddGroup.class)
    @ApiModelProperty(value = "收票人姓名")
    private String invRecName;

    /**
     * 联系方式
     */
    @NotBlank(message = "联系方式不可为空", groups = AddGroup.class)
    @Length(max = 20, message = "联系方式长度必须介于0和20之间", groups = AddGroup.class)
    @ApiModelProperty(value = "联系方式")
    private String invRecMobile;

    /**
     * 收票人省市区ID（省市区ID中间使用ID分割）
     */
//    @NotBlank(message = "收票人省市区ID不可为空", groups = AddGroup.class)
    @ApiModelProperty(value = "收票人省市区ID（省市区ID中间使用ID分割）")
    private String invRecProvince;

    /**
     * 收票详细地址
     */
    @NotBlank(message = "收票详细地址不可为空", groups = AddGroup.class)
    @ApiModelProperty(value = "收票详细地址")
    private String invRecAddr;

    /**
     * 邮箱地址
     */
    @NotBlank(message = "邮箱地址不可为空", groups = AddGroup.class)
    @Length(max = 100, message = "邮箱地址长度必须介于0和100之间", groups = AddGroup.class)
    @ApiModelProperty(value = "邮箱地址")
    private String invRecEmail;

    /**
     * 是否默认（默认0:否，1:是）
     */
    @ApiModelProperty(value = "是否默认（默认0:否，1:是）")
    private Integer isDefault;

}