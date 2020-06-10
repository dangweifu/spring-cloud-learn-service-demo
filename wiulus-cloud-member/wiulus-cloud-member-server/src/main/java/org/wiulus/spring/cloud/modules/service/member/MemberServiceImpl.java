package org.wiulus.spring.cloud.modules.service.member;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.wiulus.spring.cloud.commons.mybatis.service.impl.BaseServiceImpl;
import org.wiulus.spring.cloud.commons.tools.exception.ErrorCode;
import org.wiulus.spring.cloud.commons.tools.page.PageData;
import org.wiulus.spring.cloud.commons.tools.redis.RedisKeys;
import org.wiulus.spring.cloud.commons.tools.redis.RedisUtils;
import org.wiulus.spring.cloud.commons.tools.security.password.PasswordUtils;
import org.wiulus.spring.cloud.commons.tools.security.password.RSACoder;
import org.wiulus.spring.cloud.commons.tools.utils.ConvertUtils;
import org.wiulus.spring.cloud.commons.tools.utils.DateUtils;
//import org.wiulus.spring.cloud.dto.message.FindMessageTemplateDTO;
//import org.wiulus.spring.cloud.dto.setting.reward.RewardDTO;
//import org.wiulus.spring.cloud.dto.setting.reward.RewardSettingDTO;
//import org.wiulus.spring.cloud.enums.message.AliyunCodeEnum;
//import org.wiulus.spring.cloud.enums.message.MessageEnum;
//import org.wiulus.spring.cloud.exception.ServiceException;
//import org.wiulus.spring.cloud.logging.MonitorLogger;
//import org.wiulus.spring.cloud.logging.MonitorLoggerFactory;
//import org.wiulus.spring.cloud.modules.code.MemberStatusCode;
import org.wiulus.spring.cloud.modules.constant.RedisConstants;
import org.wiulus.spring.cloud.modules.dao.member.MemberDao;
import org.wiulus.spring.cloud.modules.dao.member.MemberInfoDao;
import org.wiulus.spring.cloud.modules.dto.address.MemberAddressDTO;
//import org.wiulus.spring.cloud.modules.dto.coupons.FrontMyCouponsPageDTO;
import org.wiulus.spring.cloud.modules.dto.grade.MemberGradeDTO;
import org.wiulus.spring.cloud.modules.dto.grade.MemberGradeSaveDTO;
import org.wiulus.spring.cloud.modules.dto.log.point.PointLogDTO;
import org.wiulus.spring.cloud.modules.dto.log.point.PointLogPackDTO;
import org.wiulus.spring.cloud.modules.dto.member.*;
//import org.wiulus.spring.cloud.modules.dto.order.LastestOrderLogisticsDTO;
//import org.wiulus.spring.cloud.modules.dto.order.MemberOrderCountDTO;
import org.wiulus.spring.cloud.modules.entity.member.MemberEntity;
import org.wiulus.spring.cloud.modules.entity.member.MemberInfoEntity;
//import org.wiulus.spring.cloud.modules.enums.ResultEnum;
import org.wiulus.spring.cloud.modules.enums.logs.PointLogDescEnum;
import org.wiulus.spring.cloud.modules.enums.logs.PointLogEnum;
import org.wiulus.spring.cloud.modules.enums.member.LoginEnum;
import org.wiulus.spring.cloud.modules.enums.member.MemberEnum;
import org.wiulus.spring.cloud.modules.enums.member.MemberErrorEnum;
import org.wiulus.spring.cloud.modules.service.address.MemberAddressService;
//import org.wiulus.spring.cloud.modules.service.browse.GoodsBrowseService;
//import org.wiulus.spring.cloud.modules.service.coupons.CouponsActivitySearchService;
//import org.wiulus.spring.cloud.modules.service.favorites.FavoritesService;
import org.wiulus.spring.cloud.modules.service.grade.MemberGradeService;
import org.wiulus.spring.cloud.modules.service.log.MemberLoginLogService;
import org.wiulus.spring.cloud.modules.service.log.point.PointLogService;
//import org.wiulus.spring.cloud.modules.service.order.OrderGoodsService;
//import org.wiulus.spring.cloud.modules.service.order.OrderLogisticsLogService;
//import org.wiulus.spring.cloud.modules.service.order.OrderService;
import org.wiulus.spring.cloud.modules.utils.MobileUtil;
import org.wiulus.spring.cloud.modules.utils.PasswdUtil;
//import org.wiulus.spring.cloud.modules.utils.member.MemberUtil;
import org.wiulus.spring.cloud.modules.vo.member.MemberVo;
import org.wiulus.spring.cloud.modules.vo.member.MemberVoDTO;
//import org.wiulus.spring.cloud.mq.constant.MqConstant;
//import org.wiulus.spring.cloud.mq.service.RabbitMqSendService;
//import org.wiulus.spring.cloud.service.message.MessageReceiverService;
//import org.wiulus.spring.cloud.service.message.MessageTextService;
//import org.wiulus.spring.cloud.service.setting.PointSettingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 会员表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@Slf4j
@RestController("memberService")
@RequestMapping("member")
public class MemberServiceImpl extends BaseServiceImpl<MemberDao, MemberEntity> implements MemberService {

//    private static MonitorLogger mlogger =
//            MonitorLoggerFactory.getMonitorLogger(MemberServiceImpl.class);

    //用户详情dao
//    @Resource
    private MemberInfoDao memberInfoDao;
//    @Resource
    private RedisUtils redisUtils;
//    @Resource
//    private RabbitMqSendService rabbitMqSendService;
//    @Qualifier("memberLoginLogService")
//    @Resource
    private MemberLoginLogService memberLoginLogService;
//    @Resource
//    @Qualifier("memberGradeService")
    private MemberGradeService memberGradeService;
//    @Resource
//    @Qualifier("memberInfoService")
    private MemberInfoService memberInfoService;
//    @Resource
//    @Qualifier("memberAddressService")
    private MemberAddressService memberAddressService;

//    @Resource
//    private MessageReceiverService messageReceiverService;
//
//    @Resource
//    private OrderService orderService;
//    @Resource
//    private GoodsBrowseService goodsBrowseService;
//    @Resource
//    private FavoritesService favoritesService;
//    @Resource
//    private OrderLogisticsLogService orderLogisticsLogService;
//    @Resource
//    private OrderGoodsService orderGoodsService;
//    @Resource
//    private MessageTextService messageTextService;
//    @Resource
//    private PointSettingService pointSettingService;
//    @Resource
    private PointLogService pointLogService;
//    @Resource
//    private CouponsActivitySearchService couponsActivitySearchService;

    /**
     * 分页查询会员管理列表
     *
     * @param params
     * @return DY 2019.5.10
     */
    @Override
    @GetMapping("page")
    public PageData<MemberListDTO> page(@RequestParam Map<String, Object> params) {
        String gradeId = (String) params.get("gradeId");
        if (StringUtils.isNotBlank(gradeId)) {
            MemberGradeSaveDTO gradeSaveDTO = memberGradeService.getMember(Long.valueOf(gradeId));
            params.put("min", gradeSaveDTO.getIntegration());
            params.put("max", gradeSaveDTO.getMaxIntegration());
        }

        //分页
        IPage<MemberEntity> page = getPage(params, "m.create_date", false);
        //查询
        List<MemberVo> list = baseDao.getPage(page, params);
        List<MemberListDTO> memberVoDTOList = new ArrayList<>();
        for (MemberVo memberVo : list) {
            MemberListDTO memberListDTO = ConvertUtils.sourceToTarget(memberVo, MemberListDTO.class);
            MemberGradeDTO memberGradeDTO = memberGradeService.selectByMemberId(memberVo.getMemberInfoEntity().getGradePoint());
            if (memberGradeDTO == null) {
                memberListDTO.setGradeName("暂无等级");
            } else {
                memberListDTO.setGradeName(memberGradeDTO.getGradeName());
            }

            memberVoDTOList.add(memberListDTO);
        }
        return getPageData(memberVoDTOList, page.getTotal(), MemberListDTO.class);
    }

    /**
     * 功能描述:
     * <导出查询>
     *
     * @param params
     * @date 2020/1/13 21:03
     * @author weixianchun
     **/
    @GetMapping("export")
    @Override
    public List<MemberDTO> export(@RequestParam Map<String, Object> params) {

        return baseDao.findListExport(params);

    }

    /**
     * 功能描述:
     * 〈站内信列表会员查询〉
     *
     * @param params 查询条件
     * @author : 刘远杰
     */
    @GetMapping("page/message")
    @Override
    public PageData<MemberDTO> pageMessage(@RequestParam Map<String, Object> params) {
        //查询
        String type = (String) params.get("type");
        String memberName = (String) params.get("memberName");
        QueryWrapper<MemberEntity> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(type)) {
            if ("0".equals(type)) {
                // 会员名称
                queryWrapper.like(StringUtils.isNotBlank(memberName), "member_name", memberName);
            } else if ("2".equals(type)) {
                queryWrapper.like(StringUtils.isNotBlank(memberName), "member_email", memberName);
            } else if ("3".equals(type)) {
                queryWrapper.like(StringUtils.isNotBlank(memberName), "nick_name", memberName);
            }
        }
        IPage<MemberEntity> page = baseDao.selectPage(getPage(params, "create_date", false), queryWrapper);

        return getPageData(page, MemberDTO.class);

    }

    /**
     * 根据id查询当前用户信息
     *
     * @param id
     * @return DY 2019.5.10
     */
    @Override
    @GetMapping("{id}")
    public MemberVoDTO selectMemberById(@PathVariable("id") Long id) {
        //todo 逻辑待改
        MemberVo memberVo = baseDao.selectMemberById(id);

        if (null != memberVo.getMemberInfoEntity().getGradePoint()) {
            MemberGradeDTO memberGradeDTO = memberGradeService.selectByMemberId(memberVo.getMemberInfoEntity().getGradePoint());
            memberVo.getMemberInfoEntity().setGradeName(memberGradeDTO.getGradeName() == null ? "" : memberGradeDTO.getGradeName());
        }

        MemberVoDTO memberVoDTO = ConvertUtils.sourceToTarget(memberVo, MemberVoDTO.class);
        MemberInfoDTO memberInfoDTO = ConvertUtils.sourceToTarget(memberVo.getMemberInfoEntity(), MemberInfoDTO.class);
        memberVoDTO.setMemberInfoDTO(memberInfoDTO);
        return memberVoDTO;
    }

    /**
     * 根据id查询会员信息
     *
     * @param id
     * @return
     */
    @Override
    @GetMapping("id/{id}")
    public MemberDTO getById(@PathVariable("id") Long id) {
        //todo 逻辑待改
        QueryWrapper<MemberEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "member_name", "nick_name", "member_mobile", "member_email", "wechat_openid", "wechat_unionid")
                .eq("id", id);
        return ConvertUtils.sourceToTarget(baseDao.selectOne(queryWrapper), MemberDTO.class);
    }

    /**
     * 功能描述:
     * 〈获得会员密码〉
     *
     * @param id 会员id
     * @author : 刘远杰
     */
    @Override
    @GetMapping("password/{id}")
    public MemberDTO getMemberPassword(@PathVariable("id") Long id) {
        QueryWrapper<MemberEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "member_passwd").eq("id", id);
        return ConvertUtils.sourceToTarget(baseDao.selectOne(queryWrapper), MemberDTO.class);
    }


    /**
     * 根据username查询认证用户信息
     *
     * @param username
     * @return
     */
    @Override
    public SecurityDTO selectSecurityUserInfo(String username) {
        SecurityDTO securityDTO = baseDao.selectSecurityUserInfo(username);
        if (securityDTO != null) {
            //clientid为本应用使用，不应该放在用户表里
            securityDTO.setClientId("client");
        }
        return securityDTO;
    }

    /**
     * 根据username查询当前用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public MemberDTO selectMemberByUserName(String userName) {
        MemberEntity memberVo = baseDao.selectMemberByUserName(userName);
        return ConvertUtils.sourceToTarget(memberVo, MemberVoDTO.class);
    }


    /**
     * 查询列表
     *
     * @param params
     * @return DY 2019.5.10
     */
    @Override
    @GetMapping("list")
    public List<MemberVoDTO> list(@RequestParam Map<String, Object> params) {
        List<MemberVo> entityList = baseDao.getList(params);
        return ConvertUtils.sourceToTarget(entityList, MemberVoDTO.class);
    }

    /**
     * 保存用户信息
     *
     * @param dto 用户详情
     *            DY 2019.5.10
     */
    @Override
    @PostMapping("register")
    public void saveMember(@RequestBody MemberRegisterDTO dto) {
        //转换
        MemberEntity memberEntity = ConvertUtils.sourceToTarget(dto, MemberEntity.class);
        MemberInfoEntity memberInfoEntity = ConvertUtils.sourceToTarget(dto, MemberInfoEntity.class);

        //memberEntity数据填充
//        MemberUtil.saveMemberFill(memberEntity);

        int success = baseDao.insert(memberEntity);

        if (success == 1) {

            //memberInfoEntity数据填充
            memberInfoEntity.setMemberId(memberEntity.getId());//关联id
            //todo 成功注册等级积分,消费积分
            memberInfoDao.insert(memberInfoEntity);

            Map<String, Object> params = new HashMap<>();
            params.put("memberId", memberEntity.getId());
            params.put("memberName", memberEntity.getMemberName());
            params.put("sourceType", PointLogEnum.WELCOME_SOURCE_TYPE.value());
            params.put("pointDesc", PointLogDescEnum.WELCOME_SOURCE_DESC.value());
            this.savePoint(params);
        }


    }

    /**
     * 查询用户是否已被注册
     *
     * @param memberMobile
     * @return
     */
    @Override
    @GetMapping("name/mobile")
    public Boolean selectMemberByUsermaneOrMobile(@RequestParam("memberMobile") String memberMobile) {

        return baseDao.selectMemberByUsermaneOrMobile(memberMobile);
    }

    /**
     * 邮箱是否被注册使用
     *
     * @param memberEmail
     * @return
     */
    @Override
    @GetMapping("email")
    public Boolean selectMemberByMemberEmail(@RequestParam("memberEmail") String memberEmail) {
        return baseDao.selectMemberByMemberEmail(memberEmail);
    }


    /**
     * 用户注册/保存
     *
     * @param params
     */
    @Override
    @PostMapping
    public Map<String, Object> saveMemberLongin(@RequestParam Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        MemberEntity memberEntity = new MemberEntity();

        String memberMobile = (String) params.get("memberMobile");
        String memberEmail = (String) params.get("memberEmail");
        int loginType = Integer.parseInt((String) params.get("loginType"));
        int memberSource = Integer.parseInt((String) params.get("memberSource"));
        memberEntity.setMemberSource(memberSource);
        //验证码校验
        String captcha = "";

        if (loginType == LoginEnum.LOGIN_EMAIL.value()) {
            // 邮箱注册
            if (StringUtils.isNotBlank(memberEmail)) {
                captcha = (String) redisUtils.get(memberEmail);
                memberEntity.setMemberEmail(memberEmail);//邮箱设置
                memberEntity.setNickName(memberEmail);
            }
        } else {
            // 手机注册
            if (StringUtils.isNotBlank(memberMobile)) {
                String key = RedisConstants.REGISTER_MOBILE_CODE_PREFIX + memberMobile;
                log.info("手机验证码的key为{}", key);
                captcha = (String) redisUtils.get(key);
                log.info("手机验证码的key为{}，值为{}", key, captcha);
                memberEntity.setMemberMobile(memberMobile);//手机设置
                memberEntity.setNickName(memberMobile);
            }
        }
        //判断验证码是否已过期
        if (StringUtils.isBlank(captcha)) {
            result.put("code", MemberErrorEnum.E_CAPTCHA_PASS.code());
            result.put("msg", MemberErrorEnum.E_CAPTCHA_PASS.value());
            return result;
        }
        String checkValidCode = (String) params.get("checkValidCode");
        if (!StringUtils.equals(captcha, checkValidCode)) {
            result.put("code", MemberErrorEnum.E_CAPTCHA_ERROR.code());
            result.put("msg", MemberErrorEnum.E_CAPTCHA_ERROR.value());
            return result;
        }

        String memberPasswd = (String) params.get("memberPasswd");
        // 密码解密
        // 使用RSA私钥进行解密
        try {
            memberPasswd = memberPasswd.replace(" ", "+");
            memberPasswd = (RSACoder.decryptByPrivateKey(memberPasswd));
        } catch (Exception e) {
//            log.error("账户:{},密码解析出现异常:{}", memberPasswd, e);
//            throw new ServiceException("密码解析失败，请重新输入");
        }

        String encodePasswd = PasswordUtils.encode(memberPasswd);
        log.debug("加密后密码为{}", encodePasswd);
        memberEntity.setMemberPasswd(encodePasswd);
        //设置用户默认头像,昵称(给已注册用户返回时用),手机注册使用手机号作为用户名,邮箱注册用邮箱作为用户名
//        MemberUtil.saveMemberFill(memberEntity);
        //会员保存
        int success = baseDao.insert(memberEntity);
        MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
        memberInfoDTO.setMemberId(memberEntity.getId());
        //保存会员信息
        memberInfoService.save(memberInfoDTO);

        // 1.如果用户注册成功，则先查询是否有积分设置 2.如果有积分设置则按照积分的规则增加积分记录
        if (success == 1) {
            Map<String, Object> memberParams = new HashMap<>();
            memberParams.put("memberId", memberEntity.getId());
            memberParams.put("memberName", memberEntity.getMemberName());
            memberParams.put("sourceType", PointLogEnum.WELCOME_SOURCE_TYPE.value());
            memberParams.put("pointDesc", PointLogDescEnum.WELCOME_SOURCE_DESC.value());
            this.savePoint(memberParams);
        }
        // 注册成功清除reids缓存
        redisUtils.delete(RedisConstants.REGISTER_MOBILE_CODE_PREFIX + memberMobile);
        result.put("code", ErrorCode.SUCCESS);
        result.put("msg", "注册成功");
        return result;
    }

    /**
     * 登录
     *
     * @param login
     * @return
     */
    @Override
    @PostMapping("login")
    public AuthorizationDTO login(@RequestBody LoginDTO login) {

        return null;
    }

    /**
     * 忘记密码:根据手机号修改
     *
     * @param params
     * @return
     */
    @Override
    @PutMapping("password")
    public void updatePasswordByMobile(@RequestParam Map<String, Object> params) {

        String mobile = params.get("mobile").toString();
        //根据手机号修改密码
        String passwd = params.get("newPwd").toString();
        String ConfirmPwd = params.get("ConfirmPwd").toString();
        // 密码解密
        // 使用RSA私钥进行解密
        try {
            passwd = passwd.replace(" ", "+");
            passwd = (RSACoder.decryptByPrivateKey(passwd));

            ConfirmPwd = ConfirmPwd.replace(" ", "+");
            ConfirmPwd = (RSACoder.decryptByPrivateKey(ConfirmPwd));

        } catch (Exception e) {
//            log.error("账户:{},密码解析出现异常:{}", passwd, e);
//            throw new ServiceException("密码解析失败，请重新输入");
        }

        if (!passwd.equals(ConfirmPwd)) {
//            throw new ServiceException(MemberStatusCode.ORDER_CHANGE_SHOW_STATUS_EXCERTION);
        }
        //加密新密码
        String encodePasswd = PasswordUtils.encode(passwd);
        baseDao.updatePasswordByMobile(mobile, encodePasswd);
    }

    /**
     * 修改密码校验
     *
     * @param params
     * @return
     */
    //todo  方法未用待删除
    @Override
    @GetMapping("verify/passwd")
    public MemberDTO verifyPasswd(@RequestParam Map<String, Object> params) {
        //获取用户信息
        MemberDTO userDetail = (MemberDTO) params.get("userDetail");
        params.get("oldPwd").toString();
        return userDetail;
    }

    @Override
    @GetMapping("all")
    public List<MemberDTO> selectAllMember(@RequestParam(value = "roleType", required = false) Integer rolleType) {
        QueryWrapper<MemberEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("del_flag", MemberEnum.DEL_FLAG_NOT.value());
        wrapper.eq(ObjectUtil.isNotNull(rolleType), "member_role", rolleType);
        List<MemberEntity> memberEntityList = baseDao.selectList(wrapper);
        return ConvertUtils.sourceToTarget(memberEntityList, MemberDTO.class);
    }

    /**
     * @author : WiuLus
     * @Description : 数据验证;是否已注册
     * @Date :2019/7/25 11:23
     * @param params 查询条件
     * @Version V1.0
     **/
    @Override
    @GetMapping("verify")
    public Map<String, Object> verify(@RequestParam Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        if (LoginEnum.LOGIN_MOBILE.value() == Integer.parseInt((String) params.get("loginType"))) {
            //手机注册
            if (StringUtils.isBlank((String) params.get("memberMobile")) || !MobileUtil.isMobile((String) params.get("memberMobile"))) {
                result.put("code", MemberErrorEnum.E_MOBILE_ERROR.code());
                result.put("msg", MemberErrorEnum.E_MOBILE_ERROR.value());
                return result;
            }
            if (selectMemberByUsermaneOrMobile((String) params.get("memberMobile"))) {
                //手机号已注册---根据手机号查询用户信息
                MemberPhoneDTO memberPhoneDTO = baseDao.selectByMobile((String) params.get("memberMobile"));
                result.put("memberPhoneDTO", memberPhoneDTO);
                result.put("code", MemberErrorEnum.E_REGISTER_SUCCESS.code());
                result.put("msg", MemberErrorEnum.E_REGISTER_SUCCESS.value());
            } else {
                //未使用手机号注册
                result.put("code", MemberErrorEnum.E_MOBILE_IS_NULL.code());
                result.put("msg", MemberErrorEnum.E_MOBILE_IS_NULL.value());
            }

        } else if (LoginEnum.LOGIN_EMAIL.value() == Integer.parseInt(params.get("loginType").toString())) {
            //邮箱注册
            if (StringUtils.isBlank((String) params.get("memberEmail"))) {
                result.put("code", MemberErrorEnum.E_EMAIL_ERROR.code());
                result.put("msg", MemberErrorEnum.E_EMAIL_ERROR.value());
            } else if (selectMemberByMemberEmail(params.get("memberEmail").toString())) {
                //已被注册
                result.put("code", MemberErrorEnum.E_EMAIL_REGISTERED.code());
                result.put("msg", MemberErrorEnum.E_EMAIL_REGISTERED.value());
            }
        } else {
            result.put("code", MemberErrorEnum.E_LOGIN_TYPE.code());
            result.put("msg", MemberErrorEnum.E_LOGIN_TYPE.value());
        }
        return result;
    }

    /**
     * 会员修改
     *
     * @param memberDTO
     */
    @Override
    @PutMapping
    public void updateMember(@RequestBody MemberUpdateDTO memberDTO) {
        MemberEntity memberEntity = ConvertUtils.sourceToTarget(memberDTO, MemberEntity.class);
        baseDao.updateById(memberEntity);

        // todo 头像、昵称、完善个人信息

//        //为null不做修改
//        if (StringUtils.isNotBlank(memberDTO.getMemberAreaid())) {
//            memberInfoService.updateByMemberId(memberDTO);
//        }
    }

    /**
     * 会员编辑回显
     */
    @GetMapping("edit/{id}")
    @Override
    public MemberUpdateDTO selectMemberUpdateDTO(@PathVariable("id") Long id) {
        return baseDao.selectMemberUpdateDTO(id);
    }

    @Override
    @DeleteMapping
    public void logicDelete(@RequestBody Long[] ids) {
        super.logicDelete(ids);
    }

    /**
     * 重置密码
     *
     * @param id
     */
    @Override
    @PutMapping("reset/{id}")
    public Map<String, Object> resetPasswd(@RequestParam("id") Long id, @RequestParam("mobile") String mobile) {
        //查询用户获取手机号
        Map<String, Object> res = new HashMap<>();
        MemberEntity memberEntity = baseDao.selectById(id);
        if (ObjectUtil.isNotNull(memberEntity)) {
            //修改密码
            String passwd = PasswdUtil.getGeneratePassword();
            // 明文密码加密
            String encode = PasswordUtils.encode(passwd);
            memberEntity.setMemberPasswd(encode);
            baseDao.updateById(memberEntity);
            //封装json
            Map<String, String> map = new HashMap<>();
            map.put("mobile", mobile);
            map.put("passwd", passwd);
            // 获取短信开关
//            FindMessageTemplateDTO findMessageTemplateDTO = messageTextService.getMessageNo(MessageEnum.SEND_MODE_SMS.value(), AliyunCodeEnum.TEMPLATECODE_RESET_PWD_CODE.value());
//            if (findMessageTemplateDTO == null || findMessageTemplateDTO.getIsSendSms() == 1) {
//                res.put("code", MemberErrorEnum.E_MESSAGE_SMS_IS_NULL.code());
//                res.put("msg", MemberErrorEnum.E_MESSAGE_SMS_IS_NULL.value());
//                return res;
//            }
//            map.put("tempSmsCode", findMessageTemplateDTO.getTempSmsCode());
//            rabbitMqSendService.sendMsg(MqConstant.LEIMINGTECH_RESET_PWD_QUEUE,
//                    JSON.toJSONString(map));
        } else {
            res.put("code", MemberErrorEnum.E_IS_NULL.code());
            res.put("msg", MemberErrorEnum.E_IS_NULL.value());
        }
        return res;
    }

    public static void main(String[] args) {

        String encode = PasswordUtils.encode("ugzbxRe7");
        System.out.println(encode);
    }

    /**
     * 修改用户状态
     *
     * @param id 用户id
     */
    @Override
    @PutMapping("status/{id}")
    public Map<String, Object> updateState(@PathVariable("id") Long id) {
        Map<String, Object> res = new HashMap<>();
        MemberEntity memberEntity = baseDao.selectById(id);
        if (ObjectUtil.isNotNull(memberEntity)) {
            if (memberEntity.getMemberState() == MemberEnum.MEMBER_STATE_NO.value()) {
                //正常
                memberEntity.setMemberState(MemberEnum.MEMBER_STATE_OFF.value());
                Object o = redisUtils.get(RedisKeys.getSecurityUserKey(memberEntity.getMemberName()));
                if (o != null) {
                    MemberDTO memberDTO = (MemberDTO) o;
                    redisUtils.delete(memberDTO.getToken());
                }
            } else {
                memberEntity.setMemberState(MemberEnum.MEMBER_STATE_NO.value());
            }
            baseDao.updateById(memberEntity);
        } else {
            res.put("code", MemberErrorEnum.E_IS_NULL.code());
            res.put("msg", MemberErrorEnum.E_IS_NULL.value());
        }
        return res;

    }

    /**
     * 根据id查询用户基本信息及地址信息
     *
     * @param id
     * @return
     */
    @Override
    @GetMapping("base/{id}")
    public MemberPersonCenterDTO selectMember(@PathVariable("id") Long id) {
        MemberPersonCenterDTO memberPersonCenterDTO = new MemberPersonCenterDTO();
        MemberVoDTO memberVoDTO = this.selectMemberById(id);
        BeanCopier.create(MemberVoDTO.class, MemberPersonCenterDTO.class, false)
                .copy(memberVoDTO, memberPersonCenterDTO, null);

        MemberAddressDTO memberAddressDTO = memberAddressService.findDefalutAddress(id);
        if (null != memberAddressDTO) {
            memberPersonCenterDTO.setAreaInfo(memberAddressDTO.getAreaInfo());
        }
        if (null != memberVoDTO.getMemberBirthday()) {
            String date = DateUtils.format(memberVoDTO.getMemberBirthday());
            memberPersonCenterDTO.setMemberBirthday(date);
        }
        //查询未读消息数量
//        memberPersonCenterDTO.setMessageNum(messageReceiverService.selectByReceiveId(id));
//        // 订单数量查询
//        MemberOrderCountDTO memberOrderCountDTO = orderService.countMemberOrder(id);
//        memberPersonCenterDTO.setPaymentNum(memberOrderCountDTO.getPaymentNum());
//        memberPersonCenterDTO.setReceivingNum(memberOrderCountDTO.getReceivingNum());
//
//        //待评价
//        Map<String, Object> params = new HashMap<>();
//        params.put("memberId", id);
//        memberPersonCenterDTO.setEvaluateNum(orderGoodsService.countNotEvaluateGoods(params));
//
//        // 未使用优惠券数量查询
//        memberPersonCenterDTO.setCouponNum(0);
//        params.put("couponsState", 0);
//        List<FrontMyCouponsPageDTO> myCouponsList = couponsActivitySearchService.myCouponsList(params);
//        if (CollectionUtils.isNotEmpty(myCouponsList)) {
//            memberPersonCenterDTO.setCouponNum(myCouponsList.size());
//        }
//
//        //收藏数量
//        memberPersonCenterDTO.setCollectNum(favoritesService.countByMemberId(id));
//        //足迹
//        memberPersonCenterDTO.setBrowseNum(goodsBrowseService.findNum(id));
//        //物流消息
//        LastestOrderLogisticsDTO newOrderLogisticsLog = orderLogisticsLogService.findNewOrderLogisticsLog(id);
//        if (newOrderLogisticsLog != null) {
//            memberPersonCenterDTO.setOrderId(newOrderLogisticsLog.getOrderId());
//            memberPersonCenterDTO.setContext(newOrderLogisticsLog.getContext());
//            memberPersonCenterDTO.setGoodsPicture(newOrderLogisticsLog.getGoodsPicture());
//            memberPersonCenterDTO.setState(newOrderLogisticsLog.getState());
//        }
        // 是否设置密码
        memberPersonCenterDTO.setPwdFlag(StringUtils.isNotBlank(memberVoDTO.getMemberPasswd()) ? MemberEnum.PWDFLAG_YES.value() : MemberEnum.PWDFLAG_NO.value());
        memberPersonCenterDTO.setGrowthValue(memberVoDTO.getMemberInfoDTO().getGradePoint());
        memberPersonCenterDTO.setMemberGraderName(memberVoDTO.getMemberInfoDTO().getGradeName());
        memberPersonCenterDTO.setPointValue(memberVoDTO.getMemberInfoDTO().getAvailablePoint());
        return memberPersonCenterDTO;
    }

    @Override
    @PutMapping("update/member")
    public Map<String, Object> updatememberById(@RequestBody MemberDTO memberDTO) {
        Map<String, Object> map = new HashMap<>();
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        Integer soureType = 0;
        String pointDesc = "";
        if (StringUtils.isNotEmpty(memberDTO.getMemberAvatar())) {
            memberEntity.setMemberAvatar(memberDTO.getMemberAvatar());

            soureType = PointLogEnum.AVATAR_SOURCE_TYPE.value();
            pointDesc = PointLogDescEnum.AVATAR_SOURCE_DESC.value();
        }
        if (null != memberDTO.getMemberSex()) {
            memberEntity.setMemberSex(memberDTO.getMemberSex());

            soureType = PointLogEnum.MEMBER_INFORMATION_SOURCE_TYPE.value();
            pointDesc = PointLogDescEnum.MEMBER_INFORMATION_SOURCE_DESC.value();
        }
        if (null != memberDTO.getMemberBirthday()) {
            memberEntity.setMemberBirthday(memberDTO.getMemberBirthday());

            soureType = PointLogEnum.MEMBER_INFORMATION_SOURCE_TYPE.value();
            pointDesc = PointLogDescEnum.MEMBER_INFORMATION_SOURCE_DESC.value();
        }
        if (StringUtils.isNotEmpty(memberDTO.getNickName())) {
            memberEntity.setNickName(memberDTO.getNickName());

            soureType = PointLogEnum.NICKNAME_SOURCE_TYPE.value();
            pointDesc = PointLogDescEnum.NICKNAME_SOURCE_DESC.value();
        }
        int result = baseDao.updateById(memberEntity);
//        if (result == ResultEnum.RESULT_COUNT.value()) {
//            map.put("code", "400");
//            map.put("msg", "保存失败");
//            return map;
//        } else {
//            Map<String, Object> memberParams = new HashMap<>();
//            memberParams.put("memberId", memberEntity.getId());
//            memberParams.put("memberName", memberEntity.getMemberName());
//            memberParams.put("sourceType", soureType);
//            memberParams.put("pointDesc", pointDesc);
//            this.savePoint(memberParams);
//        }
        map.put("code", "200");
        map.put("msg", "保存成功");
        return map;
    }

    /**
     * member基础信息修改
     *
     * @date 2019/11/11 10:25
     * @author lixiangx@wiulus.com
     **/
    @Override
    @PutMapping("/base")
    public void updateBase(@RequestBody MemberDTO memberDTO) {
        MemberEntity memberEntity = ConvertUtils.sourceToTarget(memberDTO, MemberEntity.class);
        baseDao.updateById(memberEntity);
    }

    /**
     * @author : WiuLus
     * @Description : 根据手机号查询用户信息
     * @Date :2019/7/23 17:34
     * @param memberMobile 手机号
     * @Version V1.0
     **/
    @GetMapping("member/mobile")
    @Override
    public MemberPhoneDTO selectByMobile(@RequestParam("memberMobile") String memberMobile) {
        return baseDao.selectByMobile(memberMobile);
    }

    /**
     * @param mobile:
     * @return org.wiulus.spring.cloud.modules.vo.member.MemberVoDTO
     * @Description 根据手机号查询用户
     * @author : WiuLuS
     * @Date 15:36 2019-12-19
     */
    @GetMapping("/mobile")
    @Override
    public MemberVoDTO getByMobile(@RequestParam("mobile") String mobile) {
        QueryWrapper<MemberEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_mobile", mobile).last("limit 1");
        MemberEntity memberEntity = baseDao.selectOne(queryWrapper);
        if (null != memberEntity) {
            return ConvertUtils.sourceToTarget(memberEntity, MemberVoDTO.class);
        } else {
            return null;
        }

    }

    /**
     * @param dto:
     * @return java.lang.Boolean
     * @Description 修改用户信息
     * @author : WiuLuS
     * @Date 15:38 2019-12-19
     */
    @PutMapping("update")
    @Override
    public Boolean updateById(@RequestBody MemberDTO dto) {
        MemberEntity memberEntity = ConvertUtils.sourceToTarget(dto, MemberEntity.class);
        return super.updateById(memberEntity);
    }

    /**
     * @return void
     * @Description 根据对应的类型添加用户积分和成长值
     * @author : WiuLuS
     * @Date 16:20 2019-12-25
     */
    @Override
    @PostMapping("point")
    public void savePoint(@RequestParam Map<String, Object> params) {

        Long memberId = Long.parseLong(params.get("memberId").toString());
        String memberName = (String) params.get("memberName");
        int sourceType = Integer.parseInt(params.get("sourceType").toString());
        String pointDesc = (String) params.get("pointDesc");

        // repeat=2表示积分或者成长值是永远只增加一次；repeat=1表示积分或成长值可以重复增加；
        int repeat = 2;
        if (params.get("repeat") != null) {
            repeat = Integer.parseInt(params.get("repeat").toString());
        }

//        String pointSetting = pointSettingService.findFromRedis("reward");
//        RewardSettingDTO rewardSettingDTO = JSONObject.parseObject(pointSetting, RewardSettingDTO.class);
//
//        RewardDTO rewardDTO = new RewardDTO();
//
//
//        switch (sourceType) {
//            case 1:
//                // 新手欢迎奖励
//                rewardDTO = rewardSettingDTO.getNoviceTaskSetting().getWelcome();
//                break;
//            case 2:
//                // 设置头像
//                rewardDTO = rewardSettingDTO.getNoviceTaskSetting().getAvatar();
//                break;
//            case 3:
//                // 设置昵称
//                rewardDTO = rewardSettingDTO.getNoviceTaskSetting().getNikename();
//                break;
//            case 4:
//                // 完善个人信息
//                rewardDTO = rewardSettingDTO.getNoviceTaskSetting().getInformation();
//                break;
//            case 5:
//                // 首次关注店铺
//                rewardDTO = rewardSettingDTO.getNoviceTaskSetting().getAttentionStore();
//                break;
//            case 6:
//                // 首次分享商品
//                rewardDTO = rewardSettingDTO.getNoviceTaskSetting().getSharegoods();
//                break;
//            case 7:
//                // 首次收藏商品
//                rewardDTO = rewardSettingDTO.getNoviceTaskSetting().getFavoritesgoods();
//                break;
//            case 8:
//                // 首次购物成功
//                rewardDTO = rewardSettingDTO.getNoviceTaskSetting().getFirstOrder();
//                break;
//            case 9:
//                // 首次完成评价
//                rewardDTO = rewardSettingDTO.getNoviceTaskSetting().getEvaluateOrder();
//                break;
//            case 10:
//                // 每日登录
//                rewardDTO = rewardSettingDTO.getDailyTaskSetting().getLogin();
//                break;
//        }
//
//        if (repeat == 1) {
//
//            if (rewardDTO.getGrowthValue() != 0 && rewardDTO.getPointValue() != 0) {
//
//                PointLogPackDTO pointLogPackDTO = new PointLogPackDTO(
//                        memberId,
//                        memberName,
//                        rewardDTO.getPointValue(),
//                        rewardDTO.getGrowthValue(),
//                        pointDesc,
//                        sourceType,
//                        PointLogEnum.INSERT_ALL.value());
//
//                pointLogService.packPointLog(pointLogPackDTO);
//
//            } else if (rewardDTO.getGrowthValue() != 0 && rewardDTO.getPointValue() == 0) {
//
//                PointLogPackDTO pointLogPackDTO = new PointLogPackDTO(
//                        memberId,
//                        memberName,
//                        rewardDTO.getPointValue(),
//                        rewardDTO.getGrowthValue(),
//                        pointDesc,
//                        sourceType,
//                        PointLogEnum.INSERT_GROWTH.value());
//
//                pointLogService.packPointLog(pointLogPackDTO);
//
//            } else if (rewardDTO.getGrowthValue() == 0 && rewardDTO.getPointValue() != 0) {
//
//                PointLogPackDTO pointLogPackDTO = new PointLogPackDTO(
//                        memberId,
//                        memberName,
//                        rewardDTO.getPointValue(),
//                        rewardDTO.getGrowthValue(),
//                        pointDesc,
//                        sourceType,
//                        PointLogEnum.INSERT_POINT.value());
//
//                pointLogService.packPointLog(pointLogPackDTO);
//
//            }
//        } else {
//
//            if (rewardDTO.getGrowthValue() != 0 && rewardDTO.getPointValue() != 0) {
//
//                // 查询项目中的新手奖励是否存在
//                Map<String, Object> newTask = new HashMap<String, Object>() {{
//                    put("memberId", memberId);
//                    put("sourceType", sourceType);
//                }};
//
//                List<PointLogDTO> pointLogDTOList = pointLogService.queryWithMemberId(newTask);
//
//                if (CollectionUtils.isEmpty(pointLogDTOList)) {
//                    PointLogPackDTO pointLogPackDTO = new PointLogPackDTO(
//                            memberId,
//                            memberName,
//                            rewardDTO.getPointValue(),
//                            rewardDTO.getGrowthValue(),
//                            pointDesc,
//                            sourceType,
//                            PointLogEnum.INSERT_ALL.value());
//
//                    pointLogService.packPointLog(pointLogPackDTO);
//                }
//
//            } else if (rewardDTO.getGrowthValue() != 0 && rewardDTO.getPointValue() == 0) {
//                // 查询项目中的新手奖励是否存在
//                Map<String, Object> newTask = new HashMap<String, Object>() {{
//                    put("memberId", memberId);
//                    put("sourceType", sourceType);
//                }};
//
//                List<PointLogDTO> pointLogDTOList = pointLogService.queryWithMemberId(newTask);
//
//                if (CollectionUtils.isEmpty(pointLogDTOList)) {
//                    PointLogPackDTO pointLogPackDTO = new PointLogPackDTO(
//                            memberId,
//                            memberName,
//                            rewardDTO.getPointValue(),
//                            rewardDTO.getGrowthValue(),
//                            pointDesc,
//                            sourceType,
//                            PointLogEnum.INSERT_GROWTH.value());
//
//                    pointLogService.packPointLog(pointLogPackDTO);
//                }
//            } else if (rewardDTO.getGrowthValue() == 0 && rewardDTO.getPointValue() != 0) {
//                // 查询项目中的新手奖励是否存在
//                Map<String, Object> newTask = new HashMap<String, Object>() {{
//                    put("memberId", memberId);
//                    put("sourceType", sourceType);
//                }};
//
//                List<PointLogDTO> pointLogDTOList = pointLogService.queryWithMemberId(newTask);
//
//                if (CollectionUtils.isEmpty(pointLogDTOList)) {
//                    PointLogPackDTO pointLogPackDTO = new PointLogPackDTO(
//                            memberId,
//                            memberName,
//                            rewardDTO.getPointValue(),
//                            rewardDTO.getGrowthValue(),
//                            pointDesc,
//                            sourceType,
//                            PointLogEnum.INSERT_POINT.value());
//
//                    pointLogService.packPointLog(pointLogPackDTO);
//                }
//            }
//        }


    }

    /**
     * 批量查询用户手机号
     *
     * @param memberList
     * @return
     */
    @PostMapping("batch/phone")
    @Override
    public List<MemberDTO> selectPhoneListById(@RequestBody List<Long> memberList) {
        return baseDao.selectPhoneListById(memberList);
    }

    @GetMapping("index/data")
    @Override
    public IndexMemberDataDTO indexMemberData(@RequestParam("startDateStr") String startDateStr,@RequestParam("endDateStr") String endDateStr) {
        Date startDate = DateUtils.parse(startDateStr, DateUtils.DATE_TIME_PATTERN);
        Date endDate = DateUtils.parse(endDateStr, DateUtils.DATE_TIME_PATTERN);
        return baseDao.selectIndexMemberData(startDate, endDate);
    }
}
