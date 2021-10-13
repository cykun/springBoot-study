package com.cyquen.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"myCache"})
public class CacheService {

    private static final Logger log = LoggerFactory.getLogger(CacheService.class);

    @Cacheable(key = "#p0")
    public String getSomething(String key) {
        log.info("get info from other database");
        return key + "something";
    }

    @CachePut(key = "#p0")
    public String update(String key) {
        return key + " update";
    }

    @CacheEvict(key = "#p0")
    public void delCache(String key) {
        log.info("evict " + key);
    }
}
