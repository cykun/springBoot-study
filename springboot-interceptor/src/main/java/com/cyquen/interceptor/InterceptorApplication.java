package com.cyquen.interceptor;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterceptorApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(InterceptorApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
