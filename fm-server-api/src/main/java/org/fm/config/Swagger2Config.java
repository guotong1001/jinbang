package org.fm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ProjectName：fm
 * @ClassName：Swagger2Config
 * @TODO：
 * @Auth：Mr.Zhang @Time：2020/9/14 8:57
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
@Configuration
//注解开启 swagger2 功能
@EnableSwagger2
public class Swagger2Config {


    //http://localhost:8800/swagger-ui.html

    //是否开启swagger，正式环境一般是需要关闭的
    @Value("${swagger.enabled}")
    private boolean enableSwagger;
    //api接口包扫描路径
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "org.fm.fm.controller";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否开启 (true 开启  false隐藏。生产环境建议隐藏)
                .enable(enableSwagger)
                .select()
                //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                //指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档标题(API名称)
                .title("FM压裂监测API接口在线文档")
                //文档描述
                .description("接口说明")
                //服务条款URL
                .termsOfServiceUrl("http://127.0.0.1:8800/")
                //联系信息
                .contact("geosun")
                //版本号
                .version("1.0。0")
                .build();
    }
}
