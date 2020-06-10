package org.wiulus.spring.cloud.modules.dto.invoice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author : weixianchun
 * @Description : 修改普通发票信息
 * @Date :2019/5/24 9:40
 * @Version V1.0
 **/
@Data
@ApiModel(description = "InvoiceUpdateSaveDTO")
public class InvoiceUpdateSaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 索引id
     */
    @ApiModelProperty(value = "索引id")
    private Long id;

    /**
     * 会员ID
     */
    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    /**
     * 收票人手机号
     */
    @ApiModelProperty(value = "收票人手机号")
    private String invRecMobile;

}