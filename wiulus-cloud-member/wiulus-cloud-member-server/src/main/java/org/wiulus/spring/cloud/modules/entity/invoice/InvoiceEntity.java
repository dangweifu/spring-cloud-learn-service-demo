package org.wiulus.spring.cloud.modules.entity.invoice;
import com.baomidou.mybatisplus.annotation.*;
import org.wiulus.spring.cloud.commons.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author : WiuLus
 * @Description : 用户发票信息管理
 * @Date :2019/5/27 12:09
 * @Version V1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("wls_shop_invoice")
public class InvoiceEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 发票类型（1:普通发票，2:增值税发票，3:电子发票）
     */
    private Integer invState;

    /**
     * 普通发票类型（1:个人发票，2:单位发票）
     */
    private Integer invType;

    /**
     * 公司发票抬头名称
     */
    private String invCompany;

    /**
     * 个人发票抬头名称
     */
    private String invPersonal;

    /**
     * 纳税人识别号
     */
    private String invCode;

    /**
     * 注册地址名称
     */
    private String invRegAddr;

    /**
     * 注册电话
     */
    private String invRegPhone;

    /**
     * 开户银行名称
     */
    private String invRegBname;

    /**
     * 银行帐户
     */
    private String invRegBaccount;

    /**
     * 收票人姓名
     */
    private String invRecName;

    /**
     * 收票人手机号
     */
    private String invRecMobile;

    /**
     * 收票人省市区ID（省市区ID中间使用ID分割）
     */
    private String invRecProvince;

    /**
     * 收票详细地址
     */
    private String invRecAddr;

    /**
     * 收票邮箱地址
     */
    private String invRecEmail;

    /**
     * 是否默认（默认0:否，1:是）
     */
    private Integer isDefault;

    /**
     * 审核状态（0未审核，1审核通过，2审核未通过，3审核中）只有增值税专票需要审核
     */
    private Integer auditStatus;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updater;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;

    /**
     * 删除标记（默认0:未删除,1:已删除）
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

}