package com.ucar.training.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

public class aroundAdvice {
    public Object timeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature().getName() + "的运行时间为" + (endTime - startTime) + "ns");
        return result;
    }
}
