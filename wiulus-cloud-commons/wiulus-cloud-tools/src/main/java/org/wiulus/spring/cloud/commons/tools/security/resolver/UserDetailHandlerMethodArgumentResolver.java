/**
 * https://www.leimingtech.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.security.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.wiulus.spring.cloud.commons.tools.security.user.SecurityUser;
import org.wiulus.spring.cloud.commons.tools.security.user.UserDetail;

/**
 * 当前登录用户
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
@Component
public class UserDetailHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(UserDetail.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) {
        //获取用户信息
        return SecurityUser.getUser();
    }
}