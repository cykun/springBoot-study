package com.cyquen.cache.controller;

import com.cyquen.cache.service.CacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping("/get")
    public String get() {
        return cacheService.getSomething("1");
    }

    @GetMapping("/update")
    public String update() {
        return cacheService.update("1");
    }

    @GetMapping("del")
    public String del() {
        cacheService.delCache("1");
        return "ok";
    }
}
