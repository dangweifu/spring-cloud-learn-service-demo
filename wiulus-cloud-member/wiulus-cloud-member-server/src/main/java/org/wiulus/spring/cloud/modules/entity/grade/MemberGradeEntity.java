package org.wiulus.spring.cloud.modules.entity.grade;

import com.baomidou.mybatisplus.annotation.*;
import org.wiulus.spring.cloud.commons.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 会员等级表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("wls_shop_member_grade")
public class MemberGradeEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 等级名称
     */
    private String gradeName;

    /**
     * 所需积分
     */
    private Integer integration;

    /**
     * 等级所对应的图片
     */
    private String gradeImg;

    /**
     * 会员帐号有效期
     */
    private String deadline;

    /**
     * 优惠百分比
     */
    private Integer preferential;

    /**
     * 是否是默认（默认0 非默认，1已默认）
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