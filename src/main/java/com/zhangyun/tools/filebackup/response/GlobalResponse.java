package com.zhangyun.tools.filebackup.response;

import lombok.Builder;
import lombok.Data;

/**
 * description: 全局响应
 *
 * @author: zhangyun
 * @date: 2022/7/24 15:36
 * @since: 1.0
 */
@Data
public class GlobalResponse {

    private String message;

    private Integer code;

    private Object data;

    public static GlobalResponse success() {
        GlobalResponse response = new GlobalResponse();
        response.setCode(200);
        response.setMessage("success");
        return response;
    }

    public static GlobalResponse success(String message) {
        GlobalResponse response = new GlobalResponse();
        response.setCode(200);
        response.setMessage(message);
        return response;
    }

    public static GlobalResponse fail() {
        GlobalResponse response = new GlobalResponse();
        response.setCode(400);
        response.setMessage("fail");
        return response;
    }

    public static GlobalResponse fail(String message) {
        GlobalResponse response = new GlobalResponse();
        response.setCode(400);
        response.setMessage(message);
        return response;
    }

    public static GlobalResponse fail(String message, Integer code) {
        GlobalResponse response = new GlobalResponse();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

}
