//package org.wiulus.spring.cloud.modules.service.wechat;
//
//import org.wiulus.spring.cloud.commons.tools.constant.PathConstant;
//import org.wiulus.spring.cloud.commons.tools.constant.ServiceConstant;
//import org.wiulus.spring.cloud.modules.dto.wechat.WechatAccessTokenDTO;
//import org.wiulus.spring.cloud.modules.service.wechat.fallback.WechatServiceFallback;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Map;
//
//@FeignClient(name = ServiceConstant.WIULUS_MEMBER_SERVER,
//        path = PathConstant.MEMBER_PATH + "/wechat",
//        fallback = WechatServiceFallback.class)
//public interface WechatService {
//
//    /**
//     * 微信登录
//     *
//     * @param code
//     * @return
//     */
//    @GetMapping("wxcode")
//    Map<String, Object> wechatLogin(@RequestParam("code") String code, @RequestParam("type") String type);
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
//    @GetMapping("openid/unionid")
//    WechatAccessTokenDTO getWechatOpenIdAndunionId(@RequestParam(value = "code") String code,
//                                                   @RequestParam("type") String type);
//
//    /**
//     * 获取openid
//     *
//     * @param code
//     * @return
//     */
//    @GetMapping("id/{code}")
//    String getOpenId(@PathVariable("code") String code);
//
//    /**
//     * @param code:   从h5获取到的微信code值
//     * @param mobile: 手机号
//     * @return java.util.Map<java.lang.String, java.lang.Object>
//     * @Description h5微信登录绑定手机号
//     * @author : WiuLuS
//     * @Date 14:42 2019-12-19
//     */
//    @PostMapping("wechat/mobile/bind")
//    Map<String, Object> wechatBindMobile(@RequestParam(value = "code") String code, @RequestParam(value = "mobile") String mobile);
//}
