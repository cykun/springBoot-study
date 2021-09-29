package com.cyquen.web.controller;

import com.cyquen.web.dto.RequestDto;
import com.cyquen.web.dto.ResponseDto;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;

/**
 * @author zheng
 * @since 2021/9/28
 */
@RestController
@RequestMapping("/rest")
public class RestfulController {

    @GetMapping("/hello")
    public String hello() {
        return "hello, this is springboot";
    }

    @GetMapping("/param/{id}")
    public String paramInUrl(@PathVariable String id) {
        return "id: " + id;
    }

    @PostMapping
    public ResponseDto<Object> postDemo(@RequestBody RequestDto request) {
        System.out.println(request);
        return new ResponseDto<>(200, "form method");
    }

    @PostMapping("/form")
    public ResponseDto<Object> formDemo(ServletRequest request) {
        System.out.println(request.getParameter("hello"));
        return new ResponseDto<>(200, "post method");
    }

    @PutMapping
    public ResponseDto<Object> putDemo() {
        return new ResponseDto<>(200, "put method");
    }

    @DeleteMapping
    public ResponseDto<Object> deleteDemo() {
        return new ResponseDto<>(200, "delete method");
    }
}
