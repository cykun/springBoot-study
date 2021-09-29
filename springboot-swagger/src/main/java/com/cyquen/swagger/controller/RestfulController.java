package com.cyquen.swagger.controller;

import com.cyquen.swagger.dto.RequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author zheng
 */
@RestController
@Api(value = "restController", tags = "test")
public class RestfulController {

    @GetMapping("/hello")
    public String hello(@ApiParam("this is a param") String param) {
        return "hello springboot-swagger";
    }

    @PostMapping("/post")
    @ApiOperation(value = "post")
    public String postDemo(@RequestBody RequestDto request) {
        return null;
    }

    @GetMapping("/token")
    public String token(@RequestHeader("token") String token) {
        return token;
    }

    // this api will be ignored by swagger.
    @ApiIgnore
    @GetMapping("/ignore")
    public String ignore() {
        return null;
    }
}
