/**
 * https://www.wiulus.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.exception;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.wiulus.spring.cloud.commons.tools.log.SysLogError;
import org.wiulus.spring.cloud.commons.tools.log.enums.LogTypeEnum;
import org.wiulus.spring.cloud.commons.tools.utils.HttpContextUtils;
import org.wiulus.spring.cloud.commons.tools.utils.IpUtils;
import org.wiulus.spring.cloud.commons.tools.utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;


/**
 * 异常处理器
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
@RestControllerAdvice
public class CustomExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
//    @Resource
//    private ModuleConfig moduleConfig;
//    @Resource
//    private RabbitMqSendService rabbitMqSendService;

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public Result handleCustomException(CustomException ex) {
        Result result = new Result();
        result.error(ex.getCode(), ex.getMsg());
        saveLog(ex);
        return result;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException ex) {
        Result result = new Result();
        result.error(ErrorCode.DB_RECORD_EXISTS);
        saveLog(ex);
        return result;
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex) {

        logger.error(ex.getMessage(), ex);

     HttpServletResponse response = HttpContextUtils.getHttpServletResponse();
//        if(ex instanceof ServiceException){
//            ServiceException serviceException=  (ServiceException)ex;
//            response.setStatus(500);
//            // 不能直接返回500 前端统一跳转到错误页面
//            return new Result().error(505, serviceException.getErrorCode().getCode(),serviceException.getMessage());
//        }else if(ex instanceof HystrixBadRequestException){
//            HystrixBadRequestException hystrixBadRequestException=  (HystrixBadRequestException)ex;
//            if(hystrixBadRequestException.getCause() instanceof ServiceException){
//                ServiceException serviceException = (ServiceException)hystrixBadRequestException.getCause();
//                return new Result().error(505, serviceException.getErrorCode().getCode(),serviceException.getMessage());
//            }
//
//        }

        saveLog(ex);

        return new Result().error();
    }

    /**
     * 保存异常日志
     */
    private void saveLog(Exception ex) {
        SysLogError log = new SysLogError();
        log.setType(LogTypeEnum.ERROR.value());
        //TODO 打开注释
//        log.setModule(moduleConfig.getName());

        //请求相关信息
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
        log.setRequestUri(request.getRequestURI());
        log.setRequestMethod(request.getMethod());
        log.setIp(IpUtils.getIpAddr(request));
        Map<String, String> params = HttpContextUtils.getParameterMap(request);
        if (MapUtil.isNotEmpty(params)) {
            log.setRequestParams(JSON.toJSONString(params));
        }
        //登录用户ID
        //log.setCreator(SecurityUser.getUser().getUsername());
        //异常信息
        log.setErrorInfo(ExceptionUtils.getErrorStackTrace(ex));

        //保存到Redis队列里
        log.setCreateDate(new Date());
        //TODO 使用RabbitMQ发送消息进行日志处理
//        rabbitMqSendService.sendMsg(MqConstant.WIULUS_ADMIN_ERROR_LOG_QUEUE,
//                JSON.toJSONString(log));
    }
}