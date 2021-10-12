package com.cyquen.limit;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LimitApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(LimitApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
