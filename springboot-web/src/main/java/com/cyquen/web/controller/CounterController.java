package com.cyquen.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zheng
 * @since 2021/9/28
 */
@RestController
@RequestMapping("/counter")
public class CounterController {

    private Integer count = 0;

    /**
     * Controller is a singleton, so springboot only creates one, the parameter in Controller is shared.
     * @return the number of counter.
     */
    @GetMapping
    public Integer getCount() {
        return ++count;
    }
}
