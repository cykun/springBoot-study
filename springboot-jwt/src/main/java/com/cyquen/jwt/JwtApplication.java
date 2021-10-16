package com.cyquen.jwt;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.cyquen.jwt.filter")
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(JwtApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
