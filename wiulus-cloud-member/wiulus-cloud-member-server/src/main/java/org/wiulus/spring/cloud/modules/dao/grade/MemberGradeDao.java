//package org.wiulus.spring.cloud.modules.dao.grade;
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import org.wiulus.spring.cloud.commons.mybatis.dao.BaseDao;
//import org.wiulus.spring.cloud.modules.dto.grade.MemberGradeDTO;
//import org.wiulus.spring.cloud.modules.entity.grade.MemberGradeEntity;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * 会员等级表
// *
// * @author : WiuLuS
// * @email : m13886933623@163.com
// * @Version : 1.0
// */
//@Mapper
//public interface MemberGradeDao extends BaseDao<MemberGradeEntity> {
//
//    /**
//     * 根据积分查询对应的等级
//     *
//     * @param integration
//     * @return
//     */
//    MemberGradeEntity selectByMemberId(Integer integration);
//
//    /**
//     * 列表
//     *
//     * @param params
//     * @return
//     */
//    List<MemberGradeDTO> selectMemberGrade(IPage page, @Param("params") Map<String, Object> params);
//
//    /**
//     * 获取当前等级的范围
//     *
//     * @param id
//     * @return
//     */
//    Integer selectMinNum(Long id);
//
//    /**
//     * 校验等级名称是否重复
//     *
//     * @param gradeName   等级名称
//     * @param integration 等级积分
//     * @param gradeId 等级ID
//     * @return
//     */
//    Integer findNameCount(@Param("gradeName") String gradeName,
//                          @Param("integration") Integer integration,
//                          @Param("gradeId") Long gradeId);
//
//}