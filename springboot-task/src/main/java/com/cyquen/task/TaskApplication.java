package com.cyquen.task;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zheng
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TaskApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
