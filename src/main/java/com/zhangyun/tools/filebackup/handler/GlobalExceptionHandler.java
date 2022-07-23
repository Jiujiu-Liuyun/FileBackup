package com.zhangyun.tools.filebackup.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * description: 全局异常统一处理，包装返回类型，返回错误信息
 *
 * @author: zhangyun
 * @date: 2022/7/24 02:16
 * @since: 1.0
 */
@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    public String exception() {
        return "出异常了，全局异常处理";
    }

}
