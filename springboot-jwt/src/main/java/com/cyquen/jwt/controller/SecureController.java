package com.cyquen.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SecureController {

    @GetMapping("/secure/getUserInfo")
    public String login(HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute("id");
        String name = request.getAttribute("username").toString();
        return "当前用户信息 id = " + id + ",name = " + name;
    }
}
