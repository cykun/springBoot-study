package com.cyquen.aspect;

import com.cyquen.aspect.annotation.SysLog;
import com.cyquen.aspect.bo.SysLogBO;
import com.cyquen.aspect.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Aspect
@Component
public class SysLogAspect {

    final SysLogService sysLogService;

    public SysLogAspect(SysLogService sysLogService) {
        this.sysLogService = sysLogService;
    }

    @Pointcut("@annotation(com.cyquen.aspect.annotation.SysLog)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
            saveLog(point, time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLogBO sysLogBO = new SysLogBO();
        sysLogBO.setExecTime(time);
        sysLogBO.setCreateDate(new Date());
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if (sysLog != null) {
            sysLogBO.setRemark(sysLog.value());
        }
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLogBO.setClassName(className);
        sysLogBO.setMethodName(methodName);
        Object[] args = joinPoint.getArgs();
        try {
            List<String> list = new ArrayList<>(args.length);
            for (Object o : args) {
                list.add(o.toString());
            }
            sysLogBO.setParams(list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        sysLogService.save(sysLogBO);
    }
}
