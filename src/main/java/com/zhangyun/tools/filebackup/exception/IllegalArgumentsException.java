package com.zhangyun.tools.filebackup.exception;

/**
 * description: 非法参数异常
 *
 * @author: zhangyun
 * @date: 2022/7/24 01:18
 * @since: 1.0
 */
public class IllegalArgumentsException extends FBException {

    public IllegalArgumentsException() {
        super();
    }

    public IllegalArgumentsException(String message, Integer code) {
        super(message, code);
    }

    public IllegalArgumentsException(Integer code) {
        super(code);
    }

    public IllegalArgumentsException(String message) {
        super(message);
    }
}
