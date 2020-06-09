/**
 * https://www.leimingtech.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.security.user;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.wiulus.spring.cloud.commons.tools.constant.Contants;
import org.wiulus.spring.cloud.commons.tools.redis.SellerDetailRedis;
import org.wiulus.spring.cloud.commons.tools.redis.UserDetailRedis;
import org.wiulus.spring.cloud.commons.tools.utils.HttpContextUtils;
import org.wiulus.spring.cloud.commons.tools.utils.SpringContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
@Slf4j
public class SecurityUser {

    private SecurityUser() {
    }

    private static UserDetailRedis userDetailRedis;

    /**
     * seller用户Redis
     */
    private static SellerDetailRedis sellerDetailRedis;

    static {
        userDetailRedis = SpringContextUtils.getBean(UserDetailRedis.class);
        sellerDetailRedis = SpringContextUtils.getBean(SellerDetailRedis.class);
    }

    /**
     * 获取用户信息
     */
    public static UserDetail getUser() {
        Long userId = getUserId();
        if (userId == null) {
            return null;
        }
        return userDetailRedis.get(userId);
    }

    /**
     * 获取登陆用户名信息
     *
     * @return 用户名
     * @date 2019/7/11 11:17
     * @author WiuLuS
     **/
    public static String getUserName() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();

        if (request == null) {
            return null;
        }

        // 在Spring Cloud gateway中添加filter的时候，要在header中加入含有中文属性的对象，在另外一个微服务中接受的时候，发现中文乱码，
        // 具体解决方案，是先用URLEncoder编码，然后微服务的接受的时候再解码 获取
        // 编码 在网关添加内容是编码  URLEncoder.encode(str, "UTF-8");
        // 解码 微服务获取时解码 URLDecoder.decode(str, "UTF-8");
        try {
            String userName = request.getHeader(Contants.USER_NAME_KEY);
            if (StringUtils.isNotBlank(userName)) {
                return URLDecoder.decode(userName, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            log.error("用户名解码异常:{}", e);
        }
        return null;
    }

    /**
     * 获取用户ID
     */
    public static Long getUserId() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        if (request == null) {
            return null;
        }

        String userId = request.getHeader(Contants.USER_KEY);
        if (StringUtils.isBlank(userId)) {
            return null;
        }
        return Long.parseLong(userId);
    }

    /**
     * 获取部门ID
     */
    public static Long getDeptId() {
        UserDetail user = getUser();
        if (user == null) {
            return null;
        }

        return user.getDeptId();
    }


    /**
     * 获取Seller用户信息
     *
     * @return seller用户基础信息
     * @date 2019/6/26 15:24
     * @author WiuLuS
     **/
    public static SellerDetail getSeller() {
        Long sellerId = SecurityUser.getSellerId();

        if (sellerId == null) {
            return null;
        }

        return sellerDetailRedis.get(sellerId);
    }

    /**
     * 获取sellerId
     *
     * @return sellerId
     * @date 2019/6/26 15:25
     * @author WiuLuS
     **/
    private static Long getSellerId() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();

        if (request == null) {
            return null;
        }

        String sellerId = request.getHeader(Contants.SELLER_USER_KEY);
        if (StringUtils.isBlank(sellerId)) {
            return null;
        }
        return Long.parseLong(sellerId);

    }
}