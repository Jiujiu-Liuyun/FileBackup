package com.zhangyun.tools.filebackup.exception;

/**
 * description: 空参数异常
 *
 * @author: zhangyun
 * @date: 2022/7/24 01:04
 * @since: 1.0
 */
public class BlankArgumentsException extends FBException {

    public BlankArgumentsException() {
    }

    public BlankArgumentsException(String message, Integer code) {
        super(message, code);
    }

    public BlankArgumentsException(Integer code) {
        super(code);
    }

    public BlankArgumentsException(String message) {
        super(message);
    }
}
