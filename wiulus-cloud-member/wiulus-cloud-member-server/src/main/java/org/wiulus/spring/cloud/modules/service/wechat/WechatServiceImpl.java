//package org.wiulus.spring.cloud.modules.service.wechat;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.wiulus.spring.cloud.commons.tools.exception.ErrorCode;
//import org.wiulus.spring.cloud.commons.tools.redis.RedisKeys;
//import org.wiulus.spring.cloud.commons.tools.redis.RedisUtils;
//import org.wiulus.spring.cloud.commons.tools.utils.ConvertUtils;
////import org.wiulus.spring.cloud.exception.ServiceException;
////import org.wiulus.spring.cloud.logging.MonitorLogger;
////import org.wiulus.spring.cloud.logging.MonitorLoggerFactory;
////import org.wiulus.spring.cloud.modules.code.MemberStatusCode;
//import org.wiulus.spring.cloud.modules.dao.member.MemberDao;
//import org.wiulus.spring.cloud.modules.dto.member.MemberDTO;
//import org.wiulus.spring.cloud.modules.dto.member.MemberRegisterDTO;
//import org.wiulus.spring.cloud.modules.dto.wechat.WechatAccessTokenDTO;
//import org.wiulus.spring.cloud.modules.entity.member.MemberEntity;
//import org.wiulus.spring.cloud.modules.entity.wechat.WechatInfoEntity;
////import org.wiulus.spring.cloud.modules.enums.WechatEnum;
//import org.wiulus.spring.cloud.modules.enums.member.MemberEnum;
//import org.wiulus.spring.cloud.modules.enums.member.MemberErrorEnum;
//import org.wiulus.spring.cloud.modules.service.member.MemberService;
////import org.wiulus.spring.cloud.modules.service.wxpay.WeChatPayservice;
////import org.wiulus.spring.cloud.modules.utils.member.MemberUtil;
//import org.wiulus.spring.cloud.modules.vo.member.MemberVoDTO;
////import org.wiulus.spring.cloud.upload.UploadService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * WechatServiceImpl
// * @Description 微信service
// * @author : WiuLuS
// * @Date 2019/5/25 13:40
// * @Version 1.0
// **/
//@Slf4j
//@RestController("wechatService")
//@RequestMapping("wechat")
//public class WechatServiceImpl implements WechatService {
//
////    @Autowired
//    private MemberDao memberDao;
//
////    @Autowired
////    private WechatLoginService wechatLoginService;
//
////    @Autowired
////    private WeChatPayservice weChatPayservice;
//
////    @Autowired
//    private RedisUtils redisUtils;
//
////    @Autowired
////    @Qualifier("memberService")
////    private MemberService memberService;
//
////    @Autowired
////    private UploadService uploadService;
////
////    private static MonitorLogger mlogger = MonitorLoggerFactory.getMonitorLogger(WechatServiceImpl.class);
//
//    /**
//     * 微信登录
//     *
//     * @param code
//     * @return
//     */
//    @Override
//    @GetMapping("wxcode")
//    public Map<String, Object> wechatLogin(@RequestParam("code") String code, @RequestParam("type") String type) {
//        Map<String, Object> result = new HashMap<>(4);
////        if (StringUtils.isNotBlank(code)) {
////            log.debug("------------------收到微信code:{}------------------", code);
////            JSONObject jsonObject = null;
////
////            // 如果登录类型是微信小程序登录的话，调用小程序的获取openid的接口；h5或者公众号则调其他的；
////            if (type.equals(WechatEnum.WX_MINI_PROGRAM.value())) {
////                jsonObject = weChatPayservice.getOpenid(code);
////            } else {
////                jsonObject = wechatLoginService.wechatLogin(code);
////
////            }
////
////            // 打印调取微信后的日志
////            Map<String, String> logMap = new HashMap<>();
////            logMap.put("jsonObject", jsonObject.toString());
////            mlogger.info(MemberStatusCode.MEMBER_WXOPENID_SUCCESS_CODE,MemberStatusCode.ADMIN_MEMBER_UPDATE_SUCCESS_MSG,logMap);
////
////            String accessToken = "";
////            String openId = "";
////            if (jsonObject != null) {
////                accessToken = jsonObject.getString(WechatEnum.WECHAT_ACCESS_TOKEN.value());
////                openId = jsonObject.getString(WechatEnum.WECHAT_OPENID.value());
////                String unionid = jsonObject.getString(WechatEnum.WECHAT_UNIONID.value());
////                log.debug("---------openid:{}----accessToken:{}---------", openId, accessToken);
////                // 小程序不存在accessToken，所以&&条件更改为||
////                if (StringUtils.isNotBlank(accessToken) || StringUtils.isNotBlank(openId)) {
////                    //获取微信用户信息
////                    MemberEntity memberEntity = memberDao.selectByUnionid(unionid);
////                    // 封装授权数据实体
////                    WechatAccessTokenDTO wechatAccessTokenDTO = new WechatAccessTokenDTO();
////                    wechatAccessTokenDTO.setAccessToken(accessToken);
////                    wechatAccessTokenDTO.setOpenid(openId);
////                    wechatAccessTokenDTO.setUnionid(unionid);
////                    if (memberEntity == null) {
////                        // 4.不存在该用户，进入填写手机号页面，绑定手机号
////                        result.put("code", MemberErrorEnum.E_WECHAT_MOBILE_UNBIND.code());
////                        result.put("msg", MemberErrorEnum.E_WECHAT_MOBILE_UNBIND.value());
////                        result.put("data", wechatAccessTokenDTO);
////                    } else {
////                        // 4.存在微信用户，判断是否绑定手机号
////                        if (StringUtils.isBlank(memberEntity.getMemberMobile())) {
////                            // 5.未绑定手机号，进入填写手机号页面，绑定手机号
////                            result.put("code", MemberErrorEnum.E_WECHAT_MOBILE_UNBIND.code());
////                            result.put("msg", MemberErrorEnum.E_WECHAT_MOBILE_UNBIND.value());
////                            result.put("data", wechatAccessTokenDTO);
////                        } else {
////                            // 5.已绑定手机号，放行登陆操作
////                            result.put("code", ErrorCode.SUCCESS);
////                            result.put("msg", "登录成功");
////                            result.put("unionid", unionid);
////                            result.put("mobile", memberEntity.getMemberMobile());
////                        }
////                    }
////                } else {
////                    result.put("code", MemberErrorEnum.E_WECHAT_ACCESSTOKEN_ERROR.code());
////                    result.put("msg", MemberErrorEnum.E_WECHAT_ACCESSTOKEN_ERROR.value());
////                }
////            } else {
////                result.put("code", MemberErrorEnum.E_WECHAT_ACCESSTOKEN_ERROR.code());
////                result.put("msg", MemberErrorEnum.E_WECHAT_ACCESSTOKEN_ERROR.value());
////            }
////        } else {
////            result.put("code", MemberErrorEnum.E_WECHAT_ACCESSTOKEN_ERROR.code());
////            result.put("msg", MemberErrorEnum.E_WECHAT_ACCESSTOKEN_ERROR.value());
////        }
//        return result;
//    }
//
//
//    /**
//     * 获取微信openId和unionId
//     *
//     * @param code: 微信code
//     * @param type: 操作源类型：miniwx：微信小程序 其他为H5或公众号
//     * @return 微信openId和unionId
//     * @Date 2020/1/15 15:16
//     * @author lixiangx@wiulus.com
//     **/
//    @Override
//    @GetMapping("openid/unionid")
//    public WechatAccessTokenDTO getWechatOpenIdAndunionId(@RequestParam(value = "code") String code,
//                                                          @RequestParam("type") String type) {
//
////
////        if (StringUtils.isBlank(code)) {
////            throw new ServiceException(MemberStatusCode.GET_WECHAT_OPENID_ERROR);
////        }
////        JSONObject jsonObject = null;
////        // 如果登录类型是微信小程序登录的话，调用小程序的获取openid的接口；h5或者公众号则调其他的；
////        if (type.equals(WechatEnum.WX_MINI_PROGRAM.value())) {
////            jsonObject = weChatPayservice.getOpenid(code);
////        } else {
////            jsonObject = wechatLoginService.wechatLogin(code);
////        }
////
////        if (jsonObject == null) {
////            throw new ServiceException(MemberStatusCode.GET_WECHAT_OPENID_ERROR);
////        }
////
//        WechatAccessTokenDTO wechatAccessTokenDTO = new WechatAccessTokenDTO();
////        wechatAccessTokenDTO.setAccessToken(jsonObject.getString(WechatEnum.WECHAT_ACCESS_TOKEN.value()));
////        wechatAccessTokenDTO.setOpenid(jsonObject.getString(WechatEnum.WECHAT_OPENID.value()));
////        wechatAccessTokenDTO.setUnionid(jsonObject.getString(WechatEnum.WECHAT_UNIONID.value()));
//        return wechatAccessTokenDTO;
//    }
//
//    /**
//     * 拉取用户信息(需scope为 snsapi_userinfo)
//     * get请求:https协议
//     * <p>
//     * 通过access_token和openid拉去用户信息
//     * <p>
//     * 返回: openid,nickname(昵称),sex,province(省份),city,country,headimgurl,privilege(特权),unionid
//     *
//     * @return
//     */
//    private Integer getUserMessage(String accessToken, String openId, String mobile) {
////        // 1.查询手机号是否被注册
////        MemberVoDTO member = memberService.getByMobile(mobile);
////        // 2.获取微信用户信息
////        JSONObject userMessage = new JSONObject();
////        try {
//////            userMessage = wechatLoginService.getUserMessage(accessToken, openId);
////        } catch (Exception e) {
////            return 1;
////        }
////        if (userMessage == null || userMessage.get("errcode") != null) {
////            // 获取微信用户信息错误
////            return 1;
////        }
////        WechatInfoEntity wechatInfoEntity = JSON.parseObject(userMessage.toJSONString(), WechatInfoEntity.class);
////        if (wechatInfoEntity == null) {
////            // 获取微信用户信息错误
////            return 1;
////        }
////        if (member != null) {
////            if (StringUtils.isNotBlank(member.getWechatUnionid())) {
////                // 已绑定微信
////                return 2;
////            }
////            if (MemberEnum.MEMBER_STATE_OFF.value() == member.getMemberState()) {
////                // 手机账号被禁用
////                return 3;
////            }
////            // 3.手机号已被注册，修改该用户微信openid，unionid，微信昵称
////            member.setWechatOpenid(wechatInfoEntity.getOpenId());
////            member.setWechatUnionid(wechatInfoEntity.getUnionid());
////            MemberDTO memberDTO = ConvertUtils.sourceToTarget(member, MemberDTO.class);
////            memberService.updateById(memberDTO);
////        } else {
////            // 4.手机号未被注册，使用微信信息新增用户信息
////            MemberEntity memberPO = new MemberEntity();
////            memberPO.setNickName(wechatInfoEntity.getNickName());
////            memberPO.setMemberMobile(mobile);
////            memberPO.setWechatUnionid(wechatInfoEntity.getUnionid());
////            memberPO.setWechatOpenid(wechatInfoEntity.getOpenId());
////            // 微信接口1男,2女  数据库配置 1女 2男
////            memberPO.setMemberSex(wechatInfoEntity.getSex() == 1 ?
////                    MemberEnum.MEMBER_SEX_MAN.value() : MemberEnum.MEMBER_SEX_WOMAN.value());
////            //上传头像
//////            String headimgUrl = uploadService.downloadToUrl(wechatInfoEntity.getHeadimgUrl());
//////            memberPO.setMemberAvatar(headimgUrl);
////            // 填充用户名称
//////            MemberUtil.saveMemberFill(memberPO);
////
////            //转换
////            MemberRegisterDTO memberRegisterDTO = ConvertUtils.sourceToTarget(memberPO, MemberRegisterDTO.class);
////            memberService.saveMember(memberRegisterDTO);
////
////        }
//        return 0;
//    }
//
//
//    /**
//     * 获取openid
//     *
//     * @param code
//     * @return
//     */
//    @GetMapping("id/{code}")
//    @Override
//    public String getOpenId(@PathVariable("code") String code) {
////        log.debug("------------------收到微信code:{}------------------", code);
//////        JSONObject jsonObject = wechatLoginService.wechatLogin(code);
////        String openId = "";
////        if (jsonObject != null) {
////            openId = jsonObject.getString(WechatEnum.WECHAT_OPENID.value());
////            String unionid = jsonObject.getString(WechatEnum.WECHAT_UNIONID.value());
////            log.debug("---------openid:{}---------", openId);
////            return openId;
////        } else {
//            return null;
////        }
//
//    }
//
//
//    /**
//     * 功能描述:
//     * 〈根据微信code绑定手机号〉
//     * 〈加锁解决线程问题，防止并发同一个用户创建多次〉
//     *
//     * @param code   微信accessToken
//     * @param mobile 绑定手机号
//     * @author : 刘远杰
//     */
//    @PostMapping("wechat/mobile/bind")
//    @Override
//    public synchronized Map<String, Object> wechatBindMobile(@RequestParam(value = "code") String code, @RequestParam(value = "mobile") String mobile) {
//        Map result = new HashMap<String, Object>();
//        // 1.获取redis微信授权信息
//        Object obj = redisUtils.get(RedisKeys.getWechatLoginKey(code));
//        log.info("获取key:{},微信授权信息缓存成功，result：{}", RedisKeys.getWechatLoginKey(code), obj);
//        if (obj == null) {
//            // redis不存在该用户微信授权信息
//            result.put("code", MemberErrorEnum.E_WECHAT_BIND_ACCESS_EXCERTION.code());
//            result.put("msg", MemberErrorEnum.E_WECHAT_BIND_ACCESS_EXCERTION.value());
//        } else {
//            // 存在用户微信授权信息
//            WechatAccessTokenDTO wechatAccessTokenDTO = (WechatAccessTokenDTO) obj;
//            // 获取用户信息，进行新用户保存或者原有用户更新微信绑定关系
//            Integer status = getUserMessage(wechatAccessTokenDTO.getAccessToken(), wechatAccessTokenDTO.getOpenid(), mobile);
//            if (status == 0) {
//                result.put("code", ErrorCode.SUCCESS);
//                result.put("msg", "绑定手机号成功");
//                result.put("mobile", mobile);
//                // 删除redis数据
//                redisUtils.delete(RedisKeys.getWechatLoginKey(code));
//                log.info("删除登录缓存成功，key：{}", RedisKeys.getWechatLoginKey(code));
//                redisUtils.delete(RedisKeys.getMobileBindCaptchaKey(mobile));
//                log.info("删除微信授权信息缓存成功，key：{}", RedisKeys.getMobileBindCaptchaKey(mobile));
//            } else if (status == 1) {
//                result.put("code", MemberErrorEnum.E_WECHAT_BIND_ACCESS_EXCERTION.code());
//                result.put("msg", MemberErrorEnum.E_WECHAT_BIND_ACCESS_EXCERTION.value());
//            } else if (status == 2) {
//                result.put("code", MemberErrorEnum.E_WECHAT_BINDED_MOBILE.code());
//                result.put("msg", MemberErrorEnum.E_WECHAT_BINDED_MOBILE.value());
//            }
//        }
//        return result;
//    }
//}
