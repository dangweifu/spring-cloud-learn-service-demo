package org.wiulus.spring.cloud.commons.tools.feign;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leimingtech.exception.ServiceException;
import com.leimingtech.exception.ServiceStatusCode;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@Slf4j
@Configuration
public class FeignExceptionConfiguration {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new UserErrorDecoder();
    }
    /**
     * 重新实现feign的异常处理，捕捉restful接口返回的json格式的异常信息
     *
     */
    public class UserErrorDecoder implements ErrorDecoder {

        @Override
        public Exception decode(String methodKey, Response response) {
            Exception exception = null;
            ObjectMapper mapper = new ObjectMapper();
            //空属性处理
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            try {
                String json = Util.toString(response.body().asReader());
                if (StringUtils.isEmpty(json)) {
                    return null;
                }
                JSONObject jsonObject = JSONObject.parseObject(json);
                FeignFaildResult result = new FeignFaildResult();
                result.setStatus((int)jsonObject.get("code"));
                result.setMessage(String.valueOf(jsonObject.get("msg")));


                if (result.getStatus() != HttpStatus.OK.value()) {
                    ServiceException  serviceException = new ServiceException(new ServiceStatusCode.InternalServiceStatusCode(String.valueOf(jsonObject.get("errorCode")), result.getMessage(),new Object[0]));
                    exception = new HystrixBadRequestException("",serviceException);
                }
            } catch (IOException ex) {
                log.error(ex.getMessage(), ex);
            }
            return exception;
        }
    }
}
