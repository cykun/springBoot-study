package com.cyquen.filter;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author zheng
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.cyquen.filter.filter")
public class FilterApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FilterApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
