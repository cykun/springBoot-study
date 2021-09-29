package com.cyquen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zheng
 * @since 2021/9/28
 */
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * @return the page resources/static/index.html
     */
    @GetMapping("/index")
    public String helloPage() {
        return "index";
    }
}
