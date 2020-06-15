/**
 * https://www.wiulus.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.modules.redis.member;

import org.wiulus.spring.cloud.commons.tools.redis.RedisKeys;
import org.wiulus.spring.cloud.commons.tools.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 验证码Redis
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
@Component
public class CaptchaRedis {
    /**
     * 验证码5分钟过期
     */
    private final static long EXPIRE = 60 * 5L;
    @Autowired
    private RedisUtils redisUtils;

    public void set(String uuid, String captcha) {
        String key = RedisKeys.getLoginCaptchaKey(uuid);
        redisUtils.set(key, captcha, EXPIRE);
    }

    public String get(String uuid) {
        String key = RedisKeys.getLoginCaptchaKey(uuid);
        String captcha = (String) redisUtils.get(key);

        //删除验证码
        if (captcha != null) {
            redisUtils.delete(key);
        }

        return captcha;
    }
}