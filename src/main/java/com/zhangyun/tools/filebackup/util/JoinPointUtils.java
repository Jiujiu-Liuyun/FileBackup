package com.zhangyun.tools.filebackup.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/24 08:28
 * @since: 1.0
 */
public class JoinPointUtils {

    public static String getMethodDetails(JoinPoint jp) {
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
