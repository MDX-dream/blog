package com.master.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author MDX
 * @since 2023/04/11 11:19
 */
@Data
public class Response<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -4505655308965878999L;

    //请求成功返回码为：0000
    private static final String successCode = "0000";
    //返回数据
    private T data;
    //返回码
    private String code;
    //返回描述
    private String msg;

    public Response() {
        this.code = successCode;
        this.msg = "请求成功";
    }

    public Response(String code, String msg) {
        this();
        this.code = code;
        this.msg = msg;
    }

    public Response(String code, String msg, T data) {
        this();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(T data) {
        this();
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getSuccessCode() {
        return successCode;
    }


}
