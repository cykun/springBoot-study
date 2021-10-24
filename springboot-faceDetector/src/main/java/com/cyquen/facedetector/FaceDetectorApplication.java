package com.cyquen.facedetector;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FaceDetectorApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FaceDetectorApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
