/**
 * https://www.wiulus.com
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
import org.wiulus.spring.cloud.commons.tools.security.user.SellerDetail;


/**
 * @author : WiuLuS
 * @Description : 自定义参数解析器解析SellerDetail
 * @Date : 2019/6/26 15:22
 * @version : V1.0
 */
@Component
public class SellerDetailHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(SellerDetail.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) {
        //获取用户信息
        return SecurityUser.getSeller();
    }
}