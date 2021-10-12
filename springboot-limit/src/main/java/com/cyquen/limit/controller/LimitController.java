package com.cyquen.limit.controller;

import com.cyquen.limit.config.Limit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limit")
public class LimitController {

    @GetMapping("/test1")
    @Limit(key = "limit1", permitsPerSecond = 1, timeout = 500)
    public String limit1() {
        return "ok";
    }

    @GetMapping("/test2")
    @Limit(key = "limit2", permitsPerSecond = 2, timeout = 500)
    public String limit2() {
        return "ok";
    }
}
