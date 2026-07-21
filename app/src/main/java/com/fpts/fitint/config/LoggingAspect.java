package com.fpts.fitint.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(com.fpts.fitint.aspect.LogExecution)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String signature = joinPoint.getSignature().toShortString();
        log.info(">> {} args={}", signature, Arrays.toString(joinPoint.getArgs()));

        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            log.info("<< {} in {}ms", signature, System.currentTimeMillis() - start);
            return result;
        } catch (Exception e) {
            log.error("!! {} failed: {}", signature, e.getMessage(), e);
            throw e;
        }
    }
}
