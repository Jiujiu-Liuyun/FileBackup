package com.zhangyun.tools.filebackup.aspect;

import cn.hutool.core.util.ObjectUtil;
import com.zhangyun.tools.filebackup.property.FBFileMonitorProperty;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/24 19:20
 * @since: 1.0
 */
@Aspect
@Component
@Slf4j
@Order(10)
public class FBFileFilterAspect {

    @Autowired
    private FBFileMonitorProperty property;

    private List<String> fileIgnoreList = null;

    @Pointcut("@annotation(com.zhangyun.tools.filebackup.annotation.FBFileFilter) && " +
            "execution(* com.zhangyun.tools.filebackup..*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut() && args(source)")
    public void fileFilter(ProceedingJoinPoint jp, File source) throws Throwable {
        // 获取忽略列表
        if (fileIgnoreList == null && property.getIgnoreFileList() != null) {
            fileIgnoreList = List.of(property.getIgnoreFileList().split(", "));
        }
        // 文件名在忽略列表中，直接返回
        if (fileIgnoreList.contains(source.getName())) {
            return;
        }
        // 执行方法
        jp.proceed();
    }

}
