package com.zhangyun.tools.filebackup.aspect;

import com.zhangyun.tools.filebackup.exception.BlankArgumentsException;
import com.zhangyun.tools.filebackup.exception.IllegalArgumentsException;
import com.zhangyun.tools.filebackup.util.JoinPointUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * description: 全局异常处理类，打印错误日志
 *
 * @author: zhangyun
 * @date: 2022/7/24 00:38
 * @since: 1.0
 */
@Aspect
@Component
@Slf4j
@Deprecated
public class GlobalExceptionHandlerAspect {

    @Pointcut("execution(* com.zhangyun.tools.filebackup..*.*(..)) " +
            "&& @annotation(com.zhangyun.tools.filebackup.annotation.FBExceptionHandler)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object exceptionHandler(ProceedingJoinPoint jp) throws Throwable {
        try {
            return jp.proceed();
        } catch (BlankArgumentsException bae) {
            log.error("执行{}，发生空参数异常! error message {}",
                    JoinPointUtils.getMethodDetails(jp), bae.getMessage(), bae);
            throw bae;
        } catch (IllegalArgumentsException iae) {
            log.error("执行{}，发生非法参数异常! error message {}",
                    JoinPointUtils.getMethodDetails(jp), iae.getMessage(), iae);
            throw iae;
        } catch (Throwable e) {
            log.error("执行{}，发生异常! error message {}",
                    JoinPointUtils.getMethodDetails(jp), e.getMessage(), e);
            throw e;
        }
    }


}
