///**
// * Copyright 2020 wiulus https://www.wiulus.com
// */
//
//package org.wiulus.spring.cloud.modules.service.log.point;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.google.common.collect.Lists;
//import org.wiulus.spring.cloud.commons.mybatis.service.impl.BaseServiceImpl;
//import org.wiulus.spring.cloud.commons.tools.constant.Contants;
//import org.wiulus.spring.cloud.commons.tools.page.PageData;
//import org.wiulus.spring.cloud.commons.tools.redis.RedisKeys;
//import org.wiulus.spring.cloud.commons.tools.redis.RedisUtils;
//import org.wiulus.spring.cloud.commons.tools.utils.ConvertUtils;
//import org.wiulus.spring.cloud.commons.tools.utils.DateUtils;
////import org.wiulus.spring.cloud.enums.setting.PointSettingEnum;
////import org.wiulus.spring.cloud.logging.MonitorLogger;
////import org.wiulus.spring.cloud.logging.MonitorLoggerFactory;
////import org.wiulus.spring.cloud.modules.code.MemberStatusCode;
//import org.wiulus.spring.cloud.modules.dao.log.point.PointLogDao;
//import org.wiulus.spring.cloud.modules.dto.log.point.MemberGrowthValueDTO;
//import org.wiulus.spring.cloud.modules.dto.log.point.PointLogDTO;
//import org.wiulus.spring.cloud.modules.dto.log.point.PointLogPackDTO;
//import org.wiulus.spring.cloud.modules.entity.log.point.PointLogEntity;
////import org.wiulus.spring.cloud.modules.enums.logs.PointLogEnum;
//import org.wiulus.spring.cloud.modules.service.member.MemberInfoService;
////import org.wiulus.spring.cloud.modules.service.member.MemberService;
////import org.wiulus.spring.cloud.modules.vo.member.MemberVoDTO;
////import org.wiulus.spring.cloud.mq.constant.MqConstant;
////import org.wiulus.spring.cloud.mq.service.RabbitMqSendService;
////import org.wiulus.spring.cloud.service.setting.PointSettingService;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//
///**
// * 积分日志 ServiceImpl
// *
// * @author lixiang lixiangx@wiulus.com
// * @since v1.0.0 2019-12-24
// */
//@RestController("pointLogService")
//@Transactional
//@RequestMapping("point/log")
//public class PointLogServiceImpl extends BaseServiceImpl<PointLogDao, PointLogEntity> implements PointLogService {
//
////    private static MonitorLogger mlogger = MonitorLoggerFactory.getMonitorLogger(PointLogServiceImpl.class);
////
////    @Autowired
////    private RabbitMqSendService rabbitMqSendService;
////
////    @Autowired
////    private PointSettingService pointSettingService;
//
//    @Autowired
//    private MemberInfoService memberInfoService;
//
////    @Autowired
////    private MemberService memberService;
//
//    @Autowired
//    private RedisUtils redisUtils;
//
//    @Override
//    @GetMapping("page")
//    public PageData<PointLogDTO> page(@RequestParam Map<String, Object> params) {
//        IPage<PointLogEntity> page = baseDao.selectPage(
//                getPage(params, Contants.UPDATE_DATE, false),
//                getWrapper(params)
//        );
//
//        return getPageData(page, PointLogDTO.class);
//    }
//
//    @Override
//    @GetMapping
//    public List<PointLogDTO> list(Map<String, Object> params) {
//        List<PointLogEntity> entityList = baseDao.selectList(getWrapper(params));
//
//        return ConvertUtils.sourceToTarget(entityList, PointLogDTO.class);
//    }
//
//    private QueryWrapper<PointLogEntity> getWrapper(Map<String, Object> params) {
//        QueryWrapper<PointLogEntity> wrapper = new QueryWrapper<>();
//        if (params.get("memberId") != null) {
//            String memberId = String.valueOf(params.get("memberId"));
//            wrapper.eq(StringUtils.isNotBlank(memberId), "member_id", memberId);
//        }
//        if (params.get("sourceType") != null) {
//            String sourceType = (String) params.get("sourceType");
//            wrapper.eq(sourceType != null, "source_type", sourceType);
//        }
//        if (params.get("pointType") != null) {
//            String pointType = (String) params.get("pointType");
//            wrapper.eq(pointType != null, "point_type", pointType);
//        }
//
//        // 过滤掉积分为0的记录
//        wrapper.ne("point_value",0);
//        return wrapper;
//    }
//
//    @Override
//    @GetMapping("{id}")
//    public PointLogDTO get(@PathVariable("id") Long id) {
//        PointLogEntity entity = baseDao.selectById(id);
//
//        return ConvertUtils.sourceToTarget(entity, PointLogDTO.class);
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    @PostMapping
//    public Boolean save(@RequestBody PointLogDTO dto) {
//        PointLogEntity entity = ConvertUtils.sourceToTarget(dto, PointLogEntity.class);
//
//        return insert(entity);
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
//    @Transactional(rollbackFor = Exception.class)
//    @PostMapping("batch")
//    public Boolean saveBatch(@RequestBody List<PointLogDTO> dto) {
//        List<PointLogEntity> entity = ConvertUtils.sourceToTarget(dto, PointLogEntity.class);
//        return insertBatch(entity);
//    }
//
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    @PutMapping
//    public void update(@RequestBody PointLogDTO dto) {
//        PointLogEntity entity = ConvertUtils.sourceToTarget(dto, PointLogEntity.class);
//
//        updateById(entity);
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    @DeleteMapping
//    public void delete(@RequestBody Long[] ids) {
//        //逻辑删除
//        logicDelete(ids, PointLogEntity.class);
//
//        //物理删除
////        baseDao.deleteBatchIds(Arrays.asList(ids));
//    }
//
//
//    /**
//     * 封装积分/成长值 并发送MQ进行保存、修改用户可用积分数量|成长值
//     *
//     * @param pointLogPackDTO: 封装积分/成长值DTO
//     * @Date 2019/12/24 16:43
//     * @author lixiangx@wiulus.com
//     **/
//    @Override
//    @PostMapping("pack")
//    public void packPointLog(@RequestBody PointLogPackDTO pointLogPackDTO) {
////
////        Map<String, String> logMap = new HashMap<>();
////        logMap.put("pointLogPackDTO", pointLogPackDTO.toString());
////        mlogger.info(MemberStatusCode.COMPUTE_MEMBER_POINT_CODE, MemberStatusCode.COMPUTE_MEMBER_POINT_CODE_MSG, logMap);
////
////        List<PointLogEntity> pointLogEntityList = Lists.newArrayList();
////        MemberVoDTO memberVoDTO = memberService.selectMemberById(pointLogPackDTO.getMemberId());
////
////        Integer status = pointLogPackDTO.getStatus();
////        if (status == 0) {
////            // 封装积分日志
////            PointLogEntity pointLogEntity = new PointLogEntity();
////            pointLogEntity.setMemberId(pointLogPackDTO.getMemberId());
////            pointLogEntity.setMemberName(pointLogPackDTO.getMemberName());
////            pointLogEntity.setPointValue(pointLogPackDTO.getPointValue());
////            pointLogEntity.setPointDesc(pointLogPackDTO.getPointDesc());
////            pointLogEntity.setSourceType(pointLogPackDTO.getSourceType());
////            pointLogEntity.setPointType(PointLogEnum.POINT_TYPE.value());
////            Integer availablePoint = 0;
////            if (null != memberVoDTO.getMemberInfoDTO().getAvailablePoint()){
////                availablePoint = memberVoDTO.getMemberInfoDTO().getAvailablePoint();
////            }
////            pointLogEntity.setCurrentValue(availablePoint + pointLogPackDTO.getPointValue());
////            pointLogEntityList.add(pointLogEntity);
////            logMap.clear();
////            logMap.put("pointLogEntity", pointLogEntity.toString());
////            mlogger.info(MemberStatusCode.FINAL_COMPUTE_MEMBER_POINT_CODE, MemberStatusCode.FINAL_COMPUTE_MEMBER_POINT_CODE_MSG, logMap);
////            // 封装成长值日志
////            PointLogEntity pointLogGrowthEntity = new PointLogEntity();
////            pointLogGrowthEntity.setMemberId(pointLogPackDTO.getMemberId());
////            pointLogGrowthEntity.setMemberName(pointLogPackDTO.getMemberName());
////            pointLogGrowthEntity.setPointValue(pointLogPackDTO.getGrowthValue());
////            pointLogGrowthEntity.setPointDesc(pointLogPackDTO.getPointDesc());
////            pointLogGrowthEntity.setSourceType(pointLogPackDTO.getSourceType());
////            pointLogGrowthEntity.setPointType(PointLogEnum.GROWTH_TYPE.value());
////
////            Integer gradePoint = 0;
////            if (null != memberVoDTO.getMemberInfoDTO().getGradePoint()){
////                gradePoint = memberVoDTO.getMemberInfoDTO().getGradePoint();
////            }
////
////            pointLogGrowthEntity.setCurrentValue(gradePoint + pointLogPackDTO.getGrowthValue());
////            pointLogEntityList.add(pointLogGrowthEntity);
////            logMap.clear();
////            logMap.put("pointLogGrowthEntity", pointLogGrowthEntity.toString());
////            mlogger.info(MemberStatusCode.FINAL_COMPUTE_MEMBER_POINT_CODE, MemberStatusCode.FINAL_COMPUTE_MEMBER_POINT_CODE_MSG, logMap);
////        } else if (status == 1) {
////            // 封装积分日志
////            PointLogEntity pointLogEntity = new PointLogEntity();
////            pointLogEntity.setMemberId(pointLogPackDTO.getMemberId());
////            pointLogEntity.setMemberName(pointLogPackDTO.getMemberName());
////            pointLogEntity.setPointValue(pointLogPackDTO.getPointValue());
////            pointLogEntity.setPointDesc(pointLogPackDTO.getPointDesc());
////            pointLogEntity.setSourceType(pointLogPackDTO.getSourceType());
////            pointLogEntity.setPointType(PointLogEnum.POINT_TYPE.value());
////            Integer availablePoint = 0;
////            if (null != memberVoDTO.getMemberInfoDTO().getAvailablePoint()){
////                availablePoint = memberVoDTO.getMemberInfoDTO().getAvailablePoint();
////            }
////            pointLogEntity.setCurrentValue(availablePoint + pointLogPackDTO.getPointValue());
////            pointLogEntityList.add(pointLogEntity);
////        } else if (status == 2) {
////            // 封装成长值日志
////            PointLogEntity pointLogGrowthEntity = new PointLogEntity();
////            pointLogGrowthEntity.setMemberId(pointLogPackDTO.getMemberId());
////            pointLogGrowthEntity.setMemberName(pointLogPackDTO.getMemberName());
////            pointLogGrowthEntity.setPointValue(pointLogPackDTO.getGrowthValue());
////            pointLogGrowthEntity.setPointDesc(pointLogPackDTO.getPointDesc());
////            pointLogGrowthEntity.setSourceType(pointLogPackDTO.getSourceType());
////            pointLogGrowthEntity.setPointType(PointLogEnum.GROWTH_TYPE.value());
////            Integer gradePoint = 0;
////            if (null != memberVoDTO.getMemberInfoDTO().getGradePoint()){
////                gradePoint = memberVoDTO.getMemberInfoDTO().getGradePoint();
////            }
////            pointLogGrowthEntity.setCurrentValue(gradePoint + pointLogPackDTO.getGrowthValue());
////            pointLogEntityList.add(pointLogGrowthEntity);
////        }
////
////        rabbitMqSendService.sendMsg(MqConstant.LEIMINGTECH_SAVE_POINT_LOG_QUEUE, JSON.toJSONString(pointLogEntityList));
//
//    }
//
//
//    /**
//     * 清除用户成长值（定时任务调用）
//     *
//     * @return 操作结果
//     * @Date 2019/12/25 15:08
//     * @author lixiangx@wiulus.com
//     **/
//    @Override
//    @DeleteMapping("clear")
//    public Boolean clearGrowth() {
//
//        Object obj = redisUtils.get(RedisKeys.getClearGrowthKey());
//        String moreRuleJson = "";
//        if (obj == null) {
//            // 首次执行清除成长值操作
//            // 获取成长值相关配置
////            moreRuleJson = pointSettingService.findFromRedis(PointSettingEnum.MORE_RULE_NAME.value());
//        }
//        if (StringUtils.isBlank(moreRuleJson)) {
//            return false;
//        }
//        // 解析JSON
//        JSONObject ruleJsonObj = JSONObject.parseObject(moreRuleJson);
//        // 获取计算时间
//        Integer calculationTime = ruleJsonObj.getJSONObject("growthRule").getInteger("calculationTime");
//
//        // 获取当前是本月第几天
//        int date = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//        if (date == calculationTime) {
//            // 获取计算周期
//            Integer calculationCycle = ruleJsonObj.getJSONObject("growthRule").getInteger("calculationCycle");
//
//            // 获取当前时间 yyyy-MM-dd
//            Date currentDate = DateUtils.longToDate(System.currentTimeMillis(), DateUtils.DATE_PATTERN);
//            Date startTime = null;
//
//            if (calculationCycle != 0) {
//                // 设置固定的成长值清零周期
//                startTime = DateUtils.addDateMonths(currentDate, calculationCycle - (calculationCycle * 2));
//            }
//
//            // 永久不清除成长值  将用户所有成长值增加在一起
//            List<MemberGrowthValueDTO> memberGrowthValueDTOList = baseDao.findGrowthbyTime(startTime, currentDate);
//
//            memberGrowthValueDTOList.forEach(memberGrowthValueDTO -> {
//                // 修改用户的成长值
//                memberInfoService.updateGradePoint(memberGrowthValueDTO.getMemberId(), memberGrowthValueDTO.getGrowthValue());
//            });
//
//            // 如果执行完成 清除更多规则设置Redis
//            redisUtils.delete(RedisKeys.getClearGrowthKey());
//        }
//
//        return true;
//    }
//
//
//    /**
//     * @param params: 用户id和积分类型
//     * @return java.util.List<org.wiulus.spring.cloud.modules.dto.log.point.PointLogDTO>
//     * @Description 根据用户id和积分类型查询
//     * @author : WiuLuS
//     * @Date 14:31 2019-12-25
//     */
//    @Override
//    @GetMapping("member")
//    public List<PointLogDTO> queryWithMemberId(@RequestParam Map<String, Object> params) {
//        List<PointLogEntity> entityList = baseDao.selectList(getWrapper(params));
//
//        return ConvertUtils.sourceToTarget(entityList, PointLogDTO.class);
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
//    @GetMapping("time")
//    public List<PointLogDTO> queryByTime(@RequestParam Map<String, Object> params) {
//        List<PointLogDTO> list = baseDao.findByTime(params);
//        return list;
//    }
//}
