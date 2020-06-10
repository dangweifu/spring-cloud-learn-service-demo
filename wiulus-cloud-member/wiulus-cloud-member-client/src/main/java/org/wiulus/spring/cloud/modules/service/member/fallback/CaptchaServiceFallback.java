package org.wiulus.spring.cloud.modules.service.member.fallback;

import org.wiulus.spring.cloud.commons.tools.exception.ErrorCode;
import org.wiulus.spring.cloud.modules.service.member.CaptchaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * CaptchaServiceFallback
 * @Description 验证码回调
 * @author : WiuLuS
 * @Date 2019/5/28 19:25
 * @Version 1.0
 **/
@Component
@Slf4j
public class CaptchaServiceFallback implements CaptchaService {
    @Override
    public BufferedImage create(String uuid) {
        return null;
    }

    @Override
    public String createTest(String uuid) {
        return null;
    }

    @Override
    public boolean validate(String uuid, String code) {
        return false;
    }

    @Override
    public Map<String, Object> moblieCaptcha(String mobile, String prefix) {
        log.info("手机短信验证码发送异常,进入fallback,参数{},{}", mobile, prefix);
        Map<String, Object> result = new HashMap<>();
        result.put("code", ErrorCode.INTERNAL_SERVER_ERROR);
        result.put("msg", "手机短信验证码发送异常");
        return result;
    }

    @Override
    public Map<String, Object> moblieBindCaptcha(String mobile) {
        log.info("绑定手机号发送验证码异常,进入fallback，mobile:{}", mobile);
        Map<String, Object> result = new HashMap<>(2);
        result.put("code", ErrorCode.INTERNAL_SERVER_ERROR);
        result.put("msg", "绑定手机号发送验证码异常");
        return result;
    }

    @Override
    public void emailCaptha(String email,Integer sendType) {

    }


}
