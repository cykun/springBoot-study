package com.cyquen.aspect.service;

import com.cyquen.aspect.bo.SysLogBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SysLogService {

    private static final Logger log = LoggerFactory.getLogger(SysLogService.class);

    public boolean save(SysLogBO sysLogBO) {
        log.info(sysLogBO.toString());
        return true;
    }
}
