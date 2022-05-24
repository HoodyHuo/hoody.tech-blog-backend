package tech.hoody.blog.backend.controller;

public class RespWrapper<T> {
    private T data;
    private String msg;
    private int code;

    public RespWrapper(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }


    public RespWrapper(T data) {
        this.data = data;
        this.code = 2000;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
