package com.cyquen.cache;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CacheApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
