/**
 * https://www.wiulus.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.modules.service.member;

import com.google.code.kaptcha.Producer;
import org.wiulus.spring.cloud.commons.tools.exception.ErrorCode;
import org.wiulus.spring.cloud.commons.tools.redis.RedisKeys;
import org.wiulus.spring.cloud.commons.tools.redis.RedisUtils;
//import org.wiulus.spring.cloud.dto.message.FindMessageTemplateDTO;
//import org.wiulus.spring.cloud.enums.EmailEnum;
//import org.wiulus.spring.cloud.enums.message.AliyunCodeEnum;
//import org.wiulus.spring.cloud.enums.message.MessageEnum;
import org.wiulus.spring.cloud.modules.enums.member.MemberEnum;
import org.wiulus.spring.cloud.modules.enums.member.MemberErrorEnum;
import org.wiulus.spring.cloud.modules.redis.member.CaptchaRedis;
//import org.wiulus.spring.cloud.service.SysMailTemplateService;
//import org.wiulus.spring.cloud.service.SysSmsService;
//import org.wiulus.spring.cloud.service.message.MessageTextService;
//import org.wiulus.spring.cloud.service.message.template.MessageTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 验证码
 *
 * @author : WiuLuS 2019/5/12
 * @Version : 1.0
 */
@Slf4j
@RestController("captchaService")
@RequestMapping("captcha")
public class CaptchaServiceImpl implements CaptchaService {
    @Autowired
    private Producer producer;
    @Autowired
    private CaptchaRedis captchaRedis;
    @Autowired
    private RedisUtils redisUtils;
//    @Autowired
//    private SysSmsService sysSmsService;
//    @Autowired
//    private SysMailTemplateService sysMailTemplateService;
//    @Autowired
//    private MessageTemplateService messageTemplateService;
//    @Autowired
//    private MessageTextService messageTextService;
    /**
     * 注册验证码,五分钟
     */
    public static final long ONE_MINUTE = 300L;

    @Override
    @GetMapping("{uuid}")
    public BufferedImage create(@PathVariable("uuid") String uuid) {
        //生成验证码
        String captcha = producer.createText();

        //保存验证码
        captchaRedis.set(uuid, captcha);

        return producer.createImage(captcha);

    }

    @Override
    @GetMapping("/test/{uuid}")
    public String createTest(@PathVariable("uuid") String uuid) {
        //生成验证码
        String captcha = producer.createText();

        //保存验证码
        captchaRedis.set(uuid, captcha);

        return captcha;

    }

    /**
     * 验证码是否正确
     *
     * @param uuid uuid
     * @param code 验证码
     * @return
     */
    @Override
    @GetMapping("validate")
    public boolean validate(@RequestParam("uuid") String uuid, @RequestParam("code") String code) {
        String captcha = captchaRedis.get(uuid);

        //验证码是否正确
        if (code.equalsIgnoreCase(captcha)) {
            return true;
        }

        return false;
    }

    /**
     * 获取手机验证码
     *
     * @param mobile 手机号
     * @param prefix 短信验证码redis前缀
     *
     */
    @Override
    @GetMapping("moblie")
    public Map<String, Object> moblieCaptcha(@RequestParam("mobile") String mobile, @RequestParam("prefix") String prefix) {
        Map<String, Object> result = new HashMap<>();
        //生成短信验证码
        String valid = String.valueOf(new Random().nextInt(8999) + 1000);
        //保存redis
        redisUtils.set(prefix + mobile, valid, ONE_MINUTE);
        //发送短信
        String params = "{'code':'" + valid + "'}";
        // 获取短信验证码开关
//        FindMessageTemplateDTO findMessageTemplateDTO = messageTextService.getMessageNo(MessageEnum.SEND_MODE_SMS.value(), AliyunCodeEnum.TEMPLATECODE_LOGIN_REGISTER.value());
//        if (findMessageTemplateDTO == null || findMessageTemplateDTO.getIsSendSms() == 1) {
//            result.put("code", MemberErrorEnum.E_MESSAGE_SMS_IS_NULL.code());
//            result.put("msg", MemberErrorEnum.E_MESSAGE_SMS_IS_NULL.value());
//            return result;
//        }
//        sysSmsService.send(mobile, params, findMessageTemplateDTO.getTempSmsCode());
        result.put("code", ErrorCode.SUCCESS);
        result.put("msg", "短信验证码发送成功");
        return result;
    }

    /**
     * 获取邮箱验证码
     *
     * @param email    邮箱
     * @param sendType 1 忘记密码 2 登录
     *
     */
    @Override
    @GetMapping("email")
    public void emailCaptha(@RequestParam("email") String email, @RequestParam("sendType") Integer sendType) {
        Integer valid = new Random().nextInt(8999) + 1000;//生成短信验证码
        //保存redis
        redisUtils.set(email, valid, ONE_MINUTE);
        //邮件参数
        String params = "{'code':" + valid + "}";
        String templateId=null;
//        if (sendType == MemberEnum.SEND_TYPE_FORGET_PWD.value()) {
//            templateId= EmailEnum.FORGET_PWD_EMAIL_TEMPLATE.value();
//        } else if (sendType==MemberEnum.SEND_TYPE_LOGIN.value()) {
//
//            templateId= EmailEnum.FORGET_PWD_EMAIL_TEMPLATE.value();
//        }
//
//        //发送邮件
//        try {
//            sysMailTemplateService.sendMail(Long.valueOf(templateId), email, "", params);
//        } catch (Exception e) {
//            log.error("发送邮件失败", e);
//        }

    }

    /**
     * @param mobile:
     * @return java.util.Map<java.lang.String       ,       java.lang.Object>
     * @Description 绑定手机号发送验证码
     * @author : WiuLuS
     * @Date 16:01 2019-12-19
     */
    @Override
    @GetMapping("moblie/bind")
    public Map<String, Object> moblieBindCaptcha(@RequestParam("mobile") String mobile) {
        Map<String, Object> result = new HashMap<>();

        // 获取验证码有效时间，一分钟后可以重发短信
//        Long expire = redisUtils.getExpire(RedisKeys.getMobileBindCaptchaKey(mobile));
//        if (expire <= ONE_MINUTE) {
        // 获取短信验证码开关
//        FindMessageTemplateDTO findMessageTemplateDTO = messageTextService.getMessageNo(MessageEnum.SEND_MODE_SMS.value(), AliyunCodeEnum.TEMPLATECODE_LOGIN_REGISTER.value());
//        if (findMessageTemplateDTO == null || findMessageTemplateDTO.getIsSendSms() == 1) {
//            result.put("code", MemberErrorEnum.E_MESSAGE_SMS_IS_NULL.code());
//            result.put("msg", MemberErrorEnum.E_MESSAGE_SMS_IS_NULL.value());
//            return result;
//        }
//        // 生成短信验证码
//        Integer valid = new Random().nextInt(8999) + 1000;
//        //保存redis验证码，时间3分钟
//        redisUtils.set(RedisKeys.getMobileBindCaptchaKey(mobile), String.valueOf(valid), ONE_MINUTE);
//        //发送短信
//        String params = "{'code':" + valid + "}";
//        sysSmsService.send(mobile, params, findMessageTemplateDTO.getTempSmsCode());

        result.put("code", ErrorCode.SUCCESS);
        result.put("msg", "验证码短信发送成功");
//        } else {
//            result.put("code", MemberErrorEnum.E_CAPTCHA_AGAIN.code());
//            result.put("msg", MemberErrorEnum.E_CAPTCHA_AGAIN.value());
//        }
        return result;
    }
}
