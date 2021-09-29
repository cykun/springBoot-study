package com.cyquen.swagger;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author zheng
 */
@SpringBootApplication
@EnableOpenApi
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SwaggerApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
