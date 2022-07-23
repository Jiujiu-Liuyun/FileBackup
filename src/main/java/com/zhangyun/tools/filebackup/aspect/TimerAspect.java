package com.zhangyun.tools.filebackup.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/23 16:47
 * @since: 1.0
 */
@Aspect
@Component
public class TimerAspect {

    @Around("@annotation(com.zhangyun.tools.filebackup.annotation.Timer)")
    public Object methodTimer(ProceedingJoinPoint pj) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = pj.proceed();
        long cost = System.currentTimeMillis() - start;

        System.out.println("method cost time: " + (cost / 1000.0) + "s");
        return object;
    }

}
