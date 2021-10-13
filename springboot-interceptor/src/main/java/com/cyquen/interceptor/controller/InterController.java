package com.cyquen.interceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterController {

    private static final Logger log = LoggerFactory.getLogger(InterController.class);

    @GetMapping("/test")
    public String test() {
        log.info("test");
        return "test";
    }
}
