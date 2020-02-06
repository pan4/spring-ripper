package com.dataart.edu.springripper.selfinjection;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class MyAspect {
    @Around("execution(* *(..)) && @annotation(com.dataart.edu.springripper.selfinjection.Logged)")
    public Object executeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("Call intercepted: {}({})", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        return joinPoint.proceed();
    }
}
