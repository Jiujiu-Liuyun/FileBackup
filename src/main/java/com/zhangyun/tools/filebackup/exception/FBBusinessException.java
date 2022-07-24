package com.zhangyun.tools.filebackup.exception;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/24 09:32
 * @since: 1.0
 */
public class FBBusinessException extends FBException {

    public FBBusinessException() {
        super();
    }

    public FBBusinessException(String message, Integer code) {
        super(message, code);
    }

    public FBBusinessException(Integer code) {
        super(code);
    }

    public FBBusinessException(String message) {
        super(message);
    }
}
