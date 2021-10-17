package com.cyquen.aspect;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AspectApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AspectApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
