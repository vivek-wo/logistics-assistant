package com.lanfang.logistics.vo;

import io.swagger.annotations.ApiModel;

@ApiModel("")
public class ResultVo<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResultVo<T> success(T t) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setCode(200);
        resultVo.setData(t);
        return resultVo;
    }

    public static ResultVo error(int code, String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;

    }

}
