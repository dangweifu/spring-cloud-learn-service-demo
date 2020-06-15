///**
// * Copyright 2020 wiulus https://www.wiulus.com
// */
//
//package org.wiulus.spring.cloud.modules.service.log.point;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.*;
//import org.wiulus.spring.cloud.commons.tools.constant.PathConstant;
//import org.wiulus.spring.cloud.commons.tools.constant.ServiceConstant;
//import org.wiulus.spring.cloud.commons.tools.page.PageData;
//import org.wiulus.spring.cloud.modules.dto.log.point.PointLogDTO;
//import org.wiulus.spring.cloud.modules.dto.log.point.PointLogPackDTO;
//import org.wiulus.spring.cloud.modules.service.log.fallback.point.PointLogServiceFallback;
//
//import java.util.List;
//import java.util.Map;
//
//
///**
// * 积分日志Service
// *
// * @author lixiang lixiangx@wiulus.com
// * @since v1.0.0 2019-12-24
// */
//@FeignClient(name = ServiceConstant.WIULUS_MEMBER_SERVER,
//        path = PathConstant.MEMBER_PATH + "/point/log",
//        fallback = PointLogServiceFallback.class)
//public interface PointLogService {
//
//    @GetMapping("page")
//    PageData<PointLogDTO> page(@RequestParam Map<String, Object> params);
//
//    @GetMapping
//    List<PointLogDTO> list(@RequestParam Map<String, Object> params);
//
//    @GetMapping("{id}")
//    PointLogDTO get(@PathVariable("id") Long id);
//
//    @PostMapping
//    Boolean save(@RequestBody PointLogDTO dto);
//
//    /**
//     * 批量保存
//     *
//     * @param dto: 批量保存集合
//     * @return 操作结果
//     * @Date 2019/12/24 14:44
//     * @author lixiangx@wiulus.com
//     **/
//    @PostMapping("batch")
//    Boolean saveBatch(@RequestBody List<PointLogDTO> dto);
//
//    @PutMapping
//    void update(@RequestBody PointLogDTO dto);
//
//    @DeleteMapping
//    void delete(@RequestBody Long[] ids);
//
//    /**
//     * 封装积分/成长值 并发送MQ进行保存、修改用户可用积分数量|成长值
//     *
//     * @param pointLogPackDTO: 封装积分/成长值DTO
//     * @Date 2019/12/24 16:43
//     * @author lixiangx@wiulus.com
//     **/
//    @PostMapping("pack")
//    void packPointLog(@RequestBody PointLogPackDTO pointLogPackDTO);
//
//    /**
//     * 清除用户成长值（定时任务调用）
//     *
//     * @return 操作结果
//     * @Date 2019/12/25 15:08
//     * @author lixiangx@wiulus.com
//     **/
//    @DeleteMapping("clear")
//    Boolean clearGrowth();
//
//    /**
//     * @param params: 用户id和积分类型
//     * @return java.util.List<org.wiulus.spring.cloud.modules.dto.log.point.PointLogDTO>
//     * @Description 根据用户id和积分类型查询
//     * @author : WiuLuS
//     * @Date 14:31 2019-12-25
//     */
//    @GetMapping("member")
//    List<PointLogDTO> queryWithMemberId(@RequestParam Map<String, Object> params);
//
//    /**
//     * 根据时间查询日志
//     * @param params 查询条件
//     * @return
//     * @Date 2020-01-14 16:29
//     * @author huangkeyuan@wiulus.com
//     **/
//    @GetMapping("time")
//    List<PointLogDTO> queryByTime(@RequestParam Map<String, Object> params);
//}
