package org.wiulus.spring.cloud;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.wiulus.spring.cloud.logs.logging.MonitorLogger;
import org.wiulus.spring.cloud.logs.logging.MonitorLoggerFactory;

/**
 * @author : WiuLuS
 * @version 1.0
 * @date 2020-06-10 13:57 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableApolloConfig
public class MemberApplication {
    private static MonitorLogger mlogger = MonitorLoggerFactory.getMonitorLogger(MemberApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class);
        mlogger.info("200101", "member-service启动成功");
    }
}
