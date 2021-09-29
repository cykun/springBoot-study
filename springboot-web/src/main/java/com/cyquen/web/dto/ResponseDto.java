package com.cyquen.web.dto;

import java.util.Date;

/**
 * @author zheng
 * @since 2021/9/28
 * @param <T>
 */
public class ResponseDto<T> {

    private Integer code;

    private String msg;

    private T data;

    private Date date = new Date();

    public ResponseDto(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
