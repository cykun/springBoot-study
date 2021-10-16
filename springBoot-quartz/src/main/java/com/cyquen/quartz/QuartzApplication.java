package com.cyquen.quartz;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuartzApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(QuartzApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
