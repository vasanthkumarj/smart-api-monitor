package com.example.smart_api_monitor.aspects;

import com.example.smart_api_monitor.services.AlertService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    @Autowired
    private AlertService defaultAlertService;

    @Around("execution(* com.example.smart_api_monitor.services.impl.DefaultTaskServices.*(..))")
    public Object measureTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Performance Aspect Total duration for join point execution: "+duration);
        if(duration > 500){
            defaultAlertService.alert("Execution time exceeded for Method: "+proceedingJoinPoint.getSignature().getName());
        }
        return result;
    }

}
