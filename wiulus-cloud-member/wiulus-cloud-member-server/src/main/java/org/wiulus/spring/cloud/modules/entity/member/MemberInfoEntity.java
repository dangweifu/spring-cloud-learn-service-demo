package org.wiulus.spring.cloud.modules.entity.member;
import com.baomidou.mybatisplus.annotation.*;
import org.wiulus.spring.cloud.commons.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员详细信息表
 *
 * @author : WiuLuS
 * @email  1197793912@qq.com
 * @Version : 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("wls_shop_member_info")
public class MemberInfoEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	private Long memberId;

    /**
     * 支付密码
     */
	private String paymentPasswd;

    /**
     * 用户消费积分
     */
	private Integer consumePoint;

    /**
     * 用户可用积分
     */
	private Integer availablePoint;

    /**
     * 用户等级积分
     */
	private Integer gradePoint;

	/**
	 * 用户等级
	 */
	private String gradeName;

    /**
     * 地区ID
     */
	private String memberAreaId;

    /**
     * 城市ID
     */
	private String memberCityId;

    /**
     * 省份ID
     */
	private String memberProvinceId;

	/**
	 * 街道ID
	 */
	private String stressId;

    /**
     * 地区内容
     */
	private String memberAreainfo;

	/**
	 * 用户成长值
	 */
	private Integer growthValue;
}