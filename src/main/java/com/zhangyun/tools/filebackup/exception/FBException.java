package com.zhangyun.tools.filebackup.exception;

import lombok.Data;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/24 01:05
 * @since: 1.0
 */
@Data
public class FBException extends RuntimeException{

    private Integer code;

    private String message;

    public FBException() {
        super();
    }

    public FBException(String message, Integer code) {
        super();
        this.code = code;
    }

    public FBException(Integer code) {
        this.code = code;
    }
}
