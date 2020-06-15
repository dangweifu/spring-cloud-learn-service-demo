///**
// * Copyright 2020 wiulus https://www.wiulus.com
// */
//
//package org.wiulus.spring.cloud.modules.dao.log.point;
//
//import org.wiulus.spring.cloud.commons.mybatis.dao.BaseDao;
//import org.wiulus.spring.cloud.modules.dto.log.point.MemberGrowthValueDTO;
//import org.wiulus.spring.cloud.modules.dto.log.point.PointLogDTO;
//import org.wiulus.spring.cloud.modules.entity.log.point.PointLogEntity;
//import org.apache.ibatis.annotations.Mapper;
//import org.springframework.data.repository.query.Param;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//
///**
// * 积分日志DAO
// *
// * @author lixiang lixiangx@wiulus.com
// * @since v1.0.0 2019-12-24
// */
//@Mapper
//public interface PointLogDao extends BaseDao<PointLogEntity> {
//
//
//    /**
//     * 根据时间查询用户成长值集合
//     *
//     * @param startTime: 开始时间
//     * @param endTime:   结束时间
//     * @return 用户成长值集合
//     * @Date 2019/12/26 9:58
//     * @author lixiangx@wiulus.com
//     **/
//    List<MemberGrowthValueDTO> findGrowthbyTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
//
//    /**
//     * 根据时间查询用户登录记录
//     * @return
//     * @Date 2020-01-14 16:03
//     * @author huangkeyuan@wiulus.com
//     **/
//    List<PointLogDTO> findByTime(@Param("params") Map<String, Object> params);
//
//}
