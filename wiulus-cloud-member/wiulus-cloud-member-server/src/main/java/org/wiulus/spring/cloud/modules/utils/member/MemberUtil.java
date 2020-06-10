//package org.wiulus.spring.cloud.modules.utils.member;
//
//import org.wiulus.spring.cloud.commons.tools.utils.HttpContextUtils;
//import org.wiulus.spring.cloud.commons.tools.utils.IpUtils;
////import org.wiulus.spring.cloud.dto.setting.SettingDefaultAvatarsDTO;
//import org.wiulus.spring.cloud.modules.dto.log.MemberLoginLogDTO;
//import org.wiulus.spring.cloud.modules.entity.member.MemberEntity;
//import org.wiulus.spring.cloud.modules.utils.UserAgentUtils;
////import org.wiulus.spring.cloud.service.setting.SettingService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import javax.annotation.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//
///**
// * MemberUtil
// * @Description 用户实体加工
// * @author : WiuLuS
// * @Date 2019/5/25 14:00
// * @Version 1.0
// **/
//@Slf4j
//@Component
//public class MemberUtil {
//
//    private MemberUtil() {
//    }
//
////    @PostConstruct
////    public void init() {
////        staticsettingService = settingService;
////    }
//
////    private static SettingService staticsettingService;
////
////    @Resource
////    private SettingService settingService;
//
//    /**
//     * 用户登录修改用户登录ip和时间
//     *
//     * @param memberEntity
//     * @return
//     */
//    public static MemberEntity updateMember(MemberEntity memberEntity) {
//        //获取上次的当前ip/时间作为最后登录ip/时间
//        memberEntity.setLastLoginIp(memberEntity.getMemberLoginIp());
//        memberEntity.setLastLoginDate(memberEntity.getMemberLoginTime());
//        memberEntity.setMemberLoginTime(new Date());//当前登录时间
//        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
//        memberEntity.setMemberLoginIp(IpUtils.getIpAddr(request));//当前登录ip
//        return memberEntity;
//    }
//
//
//    /**
//     * 数据填充
//     *
//     * @param memberEntity
//     * @return
//     */
//    public static MemberEntity saveMemberFill(MemberEntity memberEntity) {
//        if (StringUtils.isEmpty(memberEntity.getMemberAvatar())) {
//            //设置用户默认头像,昵称(给已注册用户返回时用)
//            SettingDefaultAvatarsDTO defaultAvatarsSet = staticsettingService.getDefaultAvatarsSet();
//            if (null == defaultAvatarsSet) {
//                log.error("查询用户默认头像设置异常");
//            }
//            memberEntity.setMemberAvatar(String.valueOf(defaultAvatarsSet.getAvatar()));
//        }
//        //填充用户名
//        if (StringUtils.isBlank(memberEntity.getMemberName())) {
//            if (StringUtils.isNotBlank(memberEntity.getMemberEmail())) {
//                memberEntity.setMemberName(memberEntity.getMemberEmail()); //邮箱注册使用邮箱为用户名
//            }
//            if (StringUtils.isNotBlank(memberEntity.getMemberMobile())) {
//                memberEntity.setMemberName(memberEntity.getMemberMobile()); //手机注册使用手机为用户名
//            }
//        }
//        return memberEntity;
//    }
//
//    /**
//     * 保存登录日志工具类
//     *
//     * @param memberEntity
//     * @return
//     */
//    public static MemberLoginLogDTO saveLoginLog(MemberEntity memberEntity) {
//        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
//        MemberLoginLogDTO memberLoginLogDTO = new MemberLoginLogDTO();
//        memberLoginLogDTO.setIp(IpUtils.getIpAddr(request));
//        memberLoginLogDTO.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
//        memberLoginLogDTO.setLoginName(memberEntity.getMemberName());
//        memberLoginLogDTO.setMemberId(memberEntity.getId());
//        if (UserAgentUtils.isComputer(request)) {
//            memberLoginLogDTO.setSource(0);
//        } else if (UserAgentUtils.isMobile(request)) {
//            memberLoginLogDTO.setSource(1);
//        } else {
//            memberLoginLogDTO.setSource(2);
//        }
//        return memberLoginLogDTO;
//    }
//}
