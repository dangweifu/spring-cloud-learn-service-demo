package org.wiulus.spring.cloud.modules.dao.member;

import org.wiulus.spring.cloud.commons.mybatis.dao.BaseDao;
import org.wiulus.spring.cloud.modules.dto.member.MemberUpdateDTO;
import org.wiulus.spring.cloud.modules.entity.member.MemberInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 会员详细信息表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@Mapper
public interface MemberInfoDao extends BaseDao<MemberInfoEntity> {

    /**
     * 根据用户id修改
     *
     * @param memberUpdateDTO
     */
    void updateByMemberId(MemberUpdateDTO memberUpdateDTO);


    /**
     * 根据分值查询人数
     *
     * @param min
     * @param max
     */
    Long selectMemberNum(@Param("min") Integer min, @Param("max") Integer max);

    /**
     * 修改会员成长值
     *
     * @param memberId:   会员ID
     * @param gradePoint: 会员等级积分（成长值）
     * @Date 2019/12/26 10:34
     * @author lixiangx@wiulus.com
     **/
    void updateGradePoint(@Param("memberId") Long memberId, @Param("gradePoint") Integer gradePoint);
}