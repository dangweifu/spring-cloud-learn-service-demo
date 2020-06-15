/**
 * https://www.wiulus.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.redis;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wiulus.spring.cloud.commons.tools.security.enums.UserKillEnum;
import org.wiulus.spring.cloud.commons.tools.security.user.UserDetail;

import java.util.Map;

/**
 * 用户Redis
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
@Component
public class UserDetailRedis {
    @Autowired
    private RedisUtils redisUtils;

    public void set(UserDetail user, long expire) {
        if (user == null) {
            return;
        }
        String key = RedisKeys.getSecurityUserKey(user.getId());
        //bean to map
        user.setKill(UserKillEnum.NO.value());
        Map<String, Object> map = BeanUtil.beanToMap(user, false, true);
        redisUtils.hMSet(key, map, expire);

        //用户登录时，清空菜单导航、权限标识
        redisUtils.delete(RedisKeys.getUserMenuNavKey(user.getId()));
        redisUtils.delete(RedisKeys.getUserPermissionsKey(user.getId()));
    }

    public UserDetail get(Long id) {
        String key = RedisKeys.getSecurityUserKey(id);

        Map<String, Object> map = redisUtils.hGetAll(key);
        if (MapUtil.isEmpty(map)) {
            return null;
        }

        //map to bean
        return BeanUtil.mapToBean(map, UserDetail.class, true);
    }

    /**
     * 用户退出
     * @param id  用户ID
     */
    public void logout(Long id) {
        String key = RedisKeys.getSecurityUserKey(id);
        redisUtils.hSet(key, "kill", UserKillEnum.YES.value());

        //清空菜单导航、权限标识
        redisUtils.deleteByPattern(RedisKeys.getUserMenuNavKey(id));
        redisUtils.delete(RedisKeys.getUserPermissionsKey(id));
    }
}