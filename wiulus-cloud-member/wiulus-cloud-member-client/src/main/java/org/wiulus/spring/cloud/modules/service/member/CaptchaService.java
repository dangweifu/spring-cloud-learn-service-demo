/**
 * https://www.wiulus.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.modules.service.member;

import org.wiulus.spring.cloud.commons.tools.constant.PathConstant;
import org.wiulus.spring.cloud.modules.service.member.fallback.CaptchaServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.wiulus.spring.cloud.commons.tools.constant.ServiceConstant;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * 验证码
 *
 * @author : WiuLuS 2019/5/12
 * @Version : 1.0
 */
@FeignClient(name = ServiceConstant.WIULUS_MEMBER_SERVER,
        path = PathConstant.MEMBER_PATH + "/captcha",
        fallback = CaptchaServiceFallback.class)
public interface CaptchaService {

    /**
     * 图片验证码
     */
    @GetMapping("{uuid}")
    BufferedImage create(@PathVariable("uuid") String uuid);
    /**
     * 图片验证码
     */
    @GetMapping("/test/{uuid}")
    String createTest(@PathVariable("uuid") String uuid);
    /**
     * 验证码效验
     *
     * @param uuid uuid
     * @param code 验证码
     * @return true：成功  false：失败
     */
    @GetMapping("validate")
    boolean validate(@RequestParam("uuid") String uuid, @RequestParam("code") String code);

    /**
     * 获取手机验证码
     *
     * @param mobile 手机号
     *
     *
     */
    @GetMapping("moblie")
    Map<String, Object> moblieCaptcha(@RequestParam("mobile") String mobile, @RequestParam("prefix") String prefix);

    /**
     * 获取邮箱验证码
     *
     * @param email 验证码
     * @param sendType 发送类型 1 忘记密码 2 登录
     *
     *
     */
    @GetMapping("email")
    void emailCaptha(@RequestParam("email") String email, @RequestParam("sendType") Integer sendType);

    /**
     * @Description  获取绑定手机号短信验证码
     * @param mobile:
     * @author : WiuLuS
     * @Date 17:21 2019-12-19
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @GetMapping("moblie/bind")
    Map<String, Object> moblieBindCaptcha(@RequestParam("mobile") String mobile);
}
