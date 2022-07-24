package com.zhangyun.tools.filebackup.handler;

import com.zhangyun.tools.filebackup.response.GlobalResponse;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    public GlobalResponse exception(Exception e) {
        log.error("发生异常 {}",e.getMessage(), e);
        return GlobalResponse.fail(e.getMessage());
    }

}
