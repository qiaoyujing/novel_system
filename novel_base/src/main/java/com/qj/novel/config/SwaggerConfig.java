package com.qj.novel.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger UI 配置信息
 */
@Configuration
@EnableSwagger2
@Profile({"dev", "test"})
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        ParameterBuilder apiTicketPar = new ParameterBuilder();
        List<Parameter> globalOperationParametersList = new ArrayList<>();

        ticketPar.name("token").description("use token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        apiTicketPar.name("AuthIdentity").description("use AuthIdentity").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        globalOperationParametersList.add(ticketPar.build());
        globalOperationParametersList.add(apiTicketPar.build());

        //设置全局响应状态码
        /*List<ResponseMessage> globalResponseMessageList = new ArrayList<>();
        globalResponseMessageList.add(new ResponseMessageBuilder().code(401).message("没有认证，请重新登录").build());
        globalResponseMessageList.add(new ResponseMessageBuilder().code(403).message("没有访问权限，请联系管理人员").build());
        globalResponseMessageList.add(new ResponseMessageBuilder().code(404).message("找不到资源").build());
        globalResponseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").build());
*/

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("API实时接口文档")
                        .description("用于实时查看、测试API")
                        // .contact(new Contact("huanzi-qch", "https://www.cnblogs.com/huanzi-qch/", ""))
                        .version("版本号:1.0")
                        .license("License")
                        .licenseUrl("/")
                        .termsOfServiceUrl("/")
                        .build())
//                .globalResponseMessage(RequestMethod.GET, globalResponseMessageList)
//                .globalResponseMessage(RequestMethod.POST, globalResponseMessageList)
                .globalOperationParameters(globalOperationParametersList)
                .select()
                //API基础扫描路径
                .apis(RequestHandlerSelectors.basePackage("com.qj"))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(Predicates.not(PathSelectors.regex("/default/*.*")))
                .build();
    }
}
