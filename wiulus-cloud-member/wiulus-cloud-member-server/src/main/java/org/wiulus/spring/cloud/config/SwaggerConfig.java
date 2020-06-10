/**
 *
 *
 * https://www.wiulus.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.config;

import org.wiulus.spring.cloud.commons.tools.constant.Contants;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


/**
 *
 * @author : WiuLuS
 * @version 1.0
 * @date 2020-06-10 13:57 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            //加了ApiOperation注解的类，才生成接口文档
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            //包下的类，才生成接口文档
            //.apis(RequestHandlerSelectors.basePackage("org.wiulus.spring.cloud.controller"))
            .paths(PathSelectors.any())
            .build()
            .directModelSubstitute(java.util.Date.class, String.class)
            .securitySchemes(security());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("维鲁斯电商1.0")
            .description("系统模块开发文档")
            .termsOfServiceUrl("https://www.wiulus.com/community")
            .version("1.1.0")
            .build();
    }

    private List<ApiKey> security() {
        return newArrayList(
                new ApiKey(Contants.ADMIN_TOKEN_HRADER, Contants.ADMIN_TOKEN_HRADER, "header"),
                new ApiKey(Contants.SELLER_TOKEN_HEADER, Contants.SELLER_TOKEN_HEADER, "header")
        );
    }

}