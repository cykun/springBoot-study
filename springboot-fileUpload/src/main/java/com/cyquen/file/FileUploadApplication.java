package com.cyquen.file;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zheng
 */
@SpringBootApplication
public class FileUploadApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FileUploadApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
