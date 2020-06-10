package org.wiulus.spring.cloud.modules.entity.address;

import com.baomidou.mybatisplus.annotation.*;
import org.wiulus.spring.cloud.commons.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 会员地址表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("wls_shop_member_address")
public class MemberAddressEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 收件人名称
     */
    private String trueName;

    /**
     * 收件人电话
     */
    private String mobPhone;

    /**
     * 地区ID
     */
    private Long areaId;

    /**
     * 省级id
     */
    private Long provinceId;

    /**
     * 市级ID
     */
    private Long cityId;

    /**
     * 市级ID
     */
    private Long stressId;

    /**
     * 地址内容
     */
    private String areaInfo;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 是否默认（ 默认为0:非默认，1:已默认）
     */
    private Integer defaultFlag;

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
     * 删除标记（默认为0未删除，1已删除）
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