///**
// * Copyright 2020 wiulus https://www.wiulus.com
// */
//
//package org.wiulus.spring.cloud.modules.service.log.fallback.point;
//
//import org.springframework.stereotype.Component;
//import org.wiulus.spring.cloud.commons.tools.page.PageData;
//import org.wiulus.spring.cloud.modules.dto.log.point.PointLogDTO;
//import org.wiulus.spring.cloud.modules.dto.log.point.PointLogPackDTO;
//import org.wiulus.spring.cloud.modules.service.log.point.PointLogService;
//
//import java.util.List;
//import java.util.Map;
//
//
///**
// * 积分日志 Fallback
// *
// * @author lixiang lixiangx@wiulus.com
// * @since v1.0.0 2019-12-24
// */
//@Component
//public class PointLogServiceFallback implements PointLogService {
//
//    @Override
//    public PageData<PointLogDTO> page(Map<String, Object> params) {
//        return null;
//    }
//
//    @Override
//    public List<PointLogDTO> list(Map<String, Object> params) {
//        return null;
//    }
//
//    @Override
//    public PointLogDTO get(Long id) {
//        return null;
//    }
//
//    @Override
//    public Boolean save(PointLogDTO dto) {
//        return false;
//    }
//
//    /**
//     * 批量保存
//     *
//     * @param dto: 批量保存集合
//     * @return 操作结果
//     * @Date 2019/12/24 14:44
//     * @author lixiangx@wiulus.com
//     **/
//    @Override
//    public Boolean saveBatch(List<PointLogDTO> dto) {
//        return false;
//    }
//
//    @Override
//    public void update(PointLogDTO dto) {
//
//    }
//
//    @Override
//    public void delete(Long[] ids) {
//
//    }
//
//    /**
//     * 封装积分/成长值 并发送MQ进行保存、修改用户可用积分数量|成长值
//     *
//     * @param pointLogPackDTO: 封装积分/成长值DTO
//     * @Date 2019/12/24 16:43
//     * @author lixiangx@wiulus.com
//     **/
//    @Override
//    public void packPointLog(PointLogPackDTO pointLogPackDTO) {
//
//    }
//
//    /**
//     * 清除用户成长值（定时任务调用）
//     *
//     * @return 操作结果
//     * @Date 2019/12/25 15:08
//     * @author lixiangx@wiulus.com
//     **/
//    @Override
//    public Boolean clearGrowth() {
//        return false;
//    }
//
//    /**
//     * @param params : 用户id和积分类型
//     * @return java.util.List<org.wiulus.spring.cloud.modules.dto.log.point.PointLogDTO>
//     * @Description 根据用户id和积分类型查询
//     * @author : WiuLuS
//     * @Date 14:31 2019-12-25
//     */
//    @Override
//    public List<PointLogDTO> queryWithMemberId(Map<String, Object> params) {
//        return null;
//    }
//
//    /**
//     * 根据时间查询日志
//     *
//     * @param params 查询条件
//     * @return
//     * @Date 2020-01-14 16:29
//     * @author huangkeyuan@wiulus.com
//     **/
//    @Override
//    public List<PointLogDTO> queryByTime(Map<String, Object> params) {
//        return null;
//    }
//}
