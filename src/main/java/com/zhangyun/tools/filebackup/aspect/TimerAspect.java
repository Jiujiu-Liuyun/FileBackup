package com.zhangyun.tools.filebackup.aspect;

import com.zhangyun.tools.filebackup.util.JoinPointUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
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
@Order(0)
public class TimerAspect {

    @Pointcut("@annotation(com.zhangyun.tools.filebackup.annotation.Timer) && " +
            "execution(* com.zhangyun.tools.filebackup..*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object methodTimer(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = jp.proceed();
        long cost = System.currentTimeMillis() - start;

        String methodDetails = JoinPointUtils.getMethodDetails(jp);
        log.info("method {} cost time: {}s", methodDetails, (cost / 1000.0));
        return object;
    }

}
