package com.cyquen.exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/exception1")
    public void exception1() {
        String str = null;
        str.length();
    }

    @GetMapping("/exception2")
    public void exception2() {
        int a = 1 / 0;
    }

    @GetMapping("/exception3")
    public void exception3() throws Exception {
        throw new Exception("");
    }
}
