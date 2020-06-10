package org.wiulus.spring.cloud.commons.tools.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.wiulus.spring.cloud.commons.tools.utils.SdkLogUtils;

/**
 * @author : WiuLuS m13886933623@163.com
 * @Description :
 * @Date : 2019/7/1 10:53
 * @version : V1.0
 */
@Slf4j
@Aspect
@Component
public class LogContextAspect {

    @Pointcut("@annotation(org.wiulus.spring.cloud.commons.tools.annotation.LogContext)")
    public void sdkLog() {
    }

    @Before(value = "sdkLog()")
    public void sdkLogBefore(JoinPoint joinPoint) {
        SdkLogUtils.handlerJoinPoint(joinPoint);
    }
}
