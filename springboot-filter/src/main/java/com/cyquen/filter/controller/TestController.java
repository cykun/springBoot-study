package com.cyquen.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zheng
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
