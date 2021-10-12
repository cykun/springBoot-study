package com.cyquen.websocket;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zheng
 */
@SpringBootApplication
public class WebsocketApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebsocketApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
