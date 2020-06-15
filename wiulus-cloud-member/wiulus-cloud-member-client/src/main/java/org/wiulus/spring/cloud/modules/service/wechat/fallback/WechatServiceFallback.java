//package org.wiulus.spring.cloud.modules.service.wechat.fallback;
//
//import org.wiulus.spring.cloud.modules.dto.wechat.WechatAccessTokenDTO;
//import org.wiulus.spring.cloud.modules.service.wechat.WechatService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
///**
// * WechatServiceFallback
// * @Description 微信回调
// * @author : WiuLuS
// * @Date 2019/5/28 21:04
// * @Version 1.0
// **/
//@Slf4j
//@Component
//public class WechatServiceFallback implements WechatService {
//
//    /**
//     * 微信登录
//     *
//     * @param code
//     * @param type
//     * @return
//     */
//    @Override
//    public Map<String, Object> wechatLogin(String code, String type) {
//        log.info("h5微信登录失败进入fallback，code:{},mobile:{}",code,type);
//        return null;
//    }
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
//    public WechatAccessTokenDTO getWechatOpenIdAndunionId(String code, String type) {
//        return null;
//    }
//
//    @Override
//    public String getOpenId(String code) {
//        return null;
//    }
//
//    /**
//     * @param code   : 从h5获取到的微信code值
//     * @param mobile : 手机号
//     * @return java.util.Map<java.lang.String, java.lang.Object>
//     * @Description h5微信登录绑定手机号
//     * @author : WiuLuS
//     * @Date 14:42 2019-12-19
//     */
//    @Override
//    public Map<String, Object> wechatBindMobile(String code, String mobile) {
//        log.info("h5微信登录失败进入fallback，code:{},mobile:{}",code,mobile);
//        return null;
//    }
//}
