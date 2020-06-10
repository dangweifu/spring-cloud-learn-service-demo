package org.wiulus.spring.cloud.modules.dto.invoice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.wiulus.spring.cloud.commons.tools.validator.group.AddGroup;

import java.io.Serializable;


/**
 * @author : weixianchun
 * @Description : 用户发票信息管理(保存普通发票)
 * @Date :2019/5/24 9:40
 * @Version V1.0
 **/
@Data
@ApiModel(description = "InvoiceSaveGeneralDTO")
public class InvoiceSaveGeneralDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 会员ID
     */
    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    /**
     * 普通发票类型（1:个人发票，2:单位发票）
     */
    @ApiModelProperty(value = "普通发票类型（1:个人发票，2:单位发票）")
    private Integer invType;

    /**
     * 个人发票抬头名称
     */
    @Length(max = 100, message = "个人发票抬头长度必须介于0和100之间", groups = AddGroup.class)
    @ApiModelProperty(value = "个人发票抬头名称")
    private String invPersonal;

    /**
     * 公司发票抬头名称
     */
    @Length(max = 100, message = "公司发票抬头长度必须介于0和100之间", groups = AddGroup.class)
    @ApiModelProperty(value = "公司发票抬头名称")
    private String invCompany;

    /**
     * 纳税人识别号
     */
    @ApiModelProperty(value = "纳税人识别号")
    private String invCode;


}