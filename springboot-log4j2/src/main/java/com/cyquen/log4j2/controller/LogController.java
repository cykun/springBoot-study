package com.cyquen.log4j2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private static final Logger log = LoggerFactory.getLogger(LogController.class);

    @GetMapping(value = "test")
    public String test() {
        log.info("This is the log test of log4j2, info level.");
        log.warn("This is the log test of log4j2, warn level.");
        log.error("This is the log test of log4j2, error level.");
        //如果在日志输出中想携带参数的化，可以这样设置
        String bug = "bug info";
        log.info("This is the output format with parameters:{}.", bug);
        return "test";
    }
}
