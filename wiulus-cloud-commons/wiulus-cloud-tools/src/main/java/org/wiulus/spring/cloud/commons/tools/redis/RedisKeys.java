/**
 * https://www.wiulus.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.redis;

import org.apache.commons.lang3.StringUtils;

/**
 * @author : WiuLuS
 * @Version : 1.0
 */
public class RedisKeys {

    private RedisKeys() {
    }

    /**
     * 系统参数Key
     */
    public static String getSysParamsKey() {
        return "sys:params";
    }

    /**
     * 登录验证码Key
     */
    public static String getLoginCaptchaKey(String uuid) {
        return "sys:captcha:" + uuid;
    }

    /**
     * security登录用户Key
     */
    public static String getSecurityUserKey(String username) {
        return "sys:security:user:" + username;
    }

    /**
     * h5用户token的key
     */
    public static String getH5UserKey(String token) {
        return "access:" + token;
    }

    /**
     * 微信登陆key
     */
    public static String getWechatLoginKey(String code) {
        return "wechat_login:" + code;
    }

    /**
     * 绑定手机号验证码Key
     */
    public static String getMobileBindCaptchaKey(String mobile) {
        return "mobile_bind_code:" + mobile;
    }

    /**
     * oauth登录用户Key
     */
    public static String getSecurityUserKey(Long id) {
        return "sys:security:user:" + id;
    }


    /**
     * 系统日志Key
     */
    public static String getSysLogKey() {
        return "sys:log";
    }

    /**
     * 系统资源Key
     */
    public static String getSysResourceKey() {
        return "sys:resource";
    }

    /**
     * 用户菜单导航Key
     */
    public static String getUserMenuNavKey(Long userId, String language) {
        return "sys:user:nav:" + userId + "_" + language;
    }

    /**
     * 用户菜单导航Key
     */
    public static String getUserMenuNavKey(Long userId) {
        return "sys:user:nav:" + userId + "_*";
    }

    /**
     * 用户权限标识Key
     */
    public static String getUserPermissionsKey(Long userId) {
        return "sys:user:permissions:" + userId;
    }

    /**
     * 获取seller端用户授权key
     *
     * @param id: 用户ID
     * @return : key
     * @date 2019/6/26 14:47
     * @author WiuLuS
     **/
    public static String getSecuritySellerKey(Long id) {
        return "seller:security:user:" + id;
    }

    /**
     * 获取seller登陆菜单key
     *
     * @param sellerId: seller用户ID
     * @return : 返回seller菜单Key
     * @date 2019/6/26 15:01
     * @author WiuLuS
     **/
    public static String getSellerMenuNavKey(Long sellerId) {
        return "seller:user:nav:" + sellerId + "_*";
    }

    /**
     * 获取seller权限key
     *
     * @param sellerId: seller用户ID
     * @return : 返回seller权限Key
     * @date 2019/6/26 15:02
     * @author WiuLuS
     **/

    public static String getSellerPermissionsKey(Long sellerId) {
        return "seller:user:permissions:" + sellerId;
    }

    /**
     * 获取购物车KEY
     *
     * @param sessionId session id
     * @return :
     */
    public static String getFrontCartKey(String sessionId) {

        return "eg:front:cart:" + sessionId;
    }

    /**
     * 首页商品实况缓存key
     */
    public static String getGoodsLiveKey(Long storeId) {
        return "seller:index:goods:" + storeId;
    }


    /**
     * 首页订单实况缓存key
     */
    public static String getOrderLiveKey(Long storeId) {
        return "seller:index:order:" + storeId;
    }

    /**
     * 系统设置Key
     *
     * @return :
     */
    public static String getSysSettingKey(String key) {
        if (StringUtils.isNotBlank(key)) {
            return "sys:setting" + key;
        }

        return "sys:setting";
    }

    /**
     * H5分类数据
     *
     * @return :
     */
    public static String getH5CustomClass() {

        return "front:custom:class";
    }

    /**
     * H5 获取热词列表
     *
     * @date 2019/12/18 9:58
     * @author m13886933623@163.com
     **/
    public static String getFrontHotWords() {
        return "front:hotword";
    }


    /**
     * Seller系统资源Key
     */
    public static String getSellerResourceKey() {
        return "seller:resource";
    }

    /**
     * 获取运营端积分设置key
     */
    public static String getPointSettingKey(String name) {
        return "sys:point:setting:" + name;
    }

    /**
     * 定时任务清除成长值时效 Redis key
     */
    public static String getClearGrowthKey() {
        return "job:clean:growth";
    }

    /**
     * 微信缓存 token、缓存key
     */
    public static String getWechatTokenKey() {
        return "wechat:token";
    }

    /**
     * 微信缓存ticket缓存 key
     *
     * @return : :
     */
    public static String getWechatTicketKey() {
        return "wechat:ticket";
    }

}
