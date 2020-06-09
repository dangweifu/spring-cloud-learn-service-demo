package org.wiulus.spring.cloud.logs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wiulus.spring.cloud.logs.environment.SDKSystemPropertiesApplicationListener;

@Configuration
public class LogConfig {

    @Value("${leimingtech.system.id}")
    private String systemId="1";

    @Bean
    @ConditionalOnMissingBean({SDKSystemPropertiesApplicationListener.class})
    public SDKSystemPropertiesApplicationListener sdkSystemPropertiesApplicationListener(){
        return new SDKSystemPropertiesApplicationListener(systemId);
    }
}
