package com.tpp.demo.util.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * SwaggerConfig
 *
 * @author Administrator
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    /**
     * @return
     */
    @Bean
    public Docket accessToken() {
        // 定义组
        return new Docket(DocumentationType.SWAGGER_2).groupName("api")
                // 选择那些路径和api会生成document
                .select()
                // 拦截的包路径
                .apis(RequestHandlerSelectors.basePackage("com.tpp.demo.controller"))
                // 拦截的接口路径
                .paths(regex("/api/.*"))
                // 创建
                .build()
                // 配置说明
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("接口文档")
                // 描述
                .description("spring boot")
                .termsOfServiceUrl("www.tpp.com")
                // 联系
                .contact(new Contact("tpp", "http://www.tpp.com", "297115770@qq.com"))
                // 版本
                .version("1.0")
                .build();
    }
}
