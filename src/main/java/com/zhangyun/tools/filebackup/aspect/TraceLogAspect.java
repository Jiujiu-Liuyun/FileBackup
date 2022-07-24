package com.zhangyun.tools.filebackup.aspect;

import com.zhangyun.tools.filebackup.util.JoinPointUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/24 08:48
 * @since: 1.0
 */
@Aspect
@Component
@Slf4j
@Order(20)
public class TraceLogAspect {

    @Before("@annotation(com.zhangyun.tools.filebackup.annotation.TraceLog)")
    public void traceLog(JoinPoint jp) {
        log.info("执行了方法：{}", JoinPointUtils.getMethodDetails(jp));
    }

}
