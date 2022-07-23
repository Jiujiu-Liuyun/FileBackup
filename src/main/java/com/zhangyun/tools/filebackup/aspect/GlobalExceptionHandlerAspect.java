package com.zhangyun.tools.filebackup.aspect;

import com.zhangyun.tools.filebackup.exception.BlankArgumentsException;
import com.zhangyun.tools.filebackup.exception.IllegalArgumentsException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * description: 全局异常处理类
 *
 * @author: zhangyun
 * @date: 2022/7/24 00:38
 * @since: 1.0
 */
@Aspect
@Component
@Slf4j
public class GlobalExceptionHandlerAspect {

    @Around("@annotation(com.zhangyun.tools.filebackup.annotation.FBExceptionHandler)")
    public Object exceptionHandler(ProceedingJoinPoint jp) {

        Object object = null;
        try {
            object = jp.proceed();
        } catch (BlankArgumentsException bae) {
            log.error("执行{}，发生空参数异常：{}",getJpDetail(jp), bae.getMessage(), bae);
            throw bae;
        } catch (IllegalArgumentsException iae) {
            log.error("非法参数异常：{}", iae.getMessage(), iae);
        } catch (Throwable e) {
            log.error("发生未知异常：{}", e.getMessage(), e);
        }

        return object;
    }

    private String getJpDetail(ProceedingJoinPoint jp) {
        //获取类的字节码对象，通过字节码对象获取方法信息
        Class<?> targetCls = jp.getTarget().getClass();
        //获取方法签名(通过此签名获取目标方法信息)
        MethodSignature ms=(MethodSignature)jp.getSignature();
        //获取目标方法名(目标类型+方法名)
        String targetClsName=targetCls.getName();
        String targetObjectMethodName=targetClsName+"."+ms.getName();
        //获取请求参数
        String targetMethodParams= Arrays.toString(jp.getArgs());
        return targetObjectMethodName + targetMethodParams;
    }


}
