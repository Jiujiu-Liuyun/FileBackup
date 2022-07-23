package com.zhangyun.tools.filebackup.aspect;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TimerAspect {

    @Around("@annotation(com.zhangyun.tools.filebackup.annotation.Timer)")
    public Object methodTimer(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = jp.proceed();
        long cost = System.currentTimeMillis() - start;

        log.info("method cost time: {}s", (cost / 1000));
        return object;
    }

}
