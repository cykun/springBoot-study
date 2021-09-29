package com.cyquen.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zheng
 * access url: http://localhost:8080/swagger-ui/
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        // Add the request parameter, here, we pass the token as the request header
        // parameter to the backend.
        RequestParameterBuilder parameterBuilder = new RequestParameterBuilder();
        List<RequestParameter> parameters = new ArrayList<>(1);
        parameterBuilder.name("token")
                .description("token")
                .required(false)
                .build();
        parameters.add(parameterBuilder.build());

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cyquen.swagger.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(parameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("springboot-swagger api demo")
                .description("springboot-swagger api demo")
                .contact(new Contact("cyquen", "url", "email"))
                .version("1.0.0")
                .build();
    }
}
