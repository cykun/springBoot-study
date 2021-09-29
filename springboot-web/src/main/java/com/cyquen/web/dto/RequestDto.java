package com.cyquen.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author zheng
 * @since 2021/9/28
 */
public class RequestDto {

    private Integer id;

    private String param;

    /**
     * spring:
     *   jackson:
     *     date-format: yyyy-MM-dd HH:mm:ss
     *     time-zone: GMT+8
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "id=" + id +
                ", param='" + param + '\'' +
                ", date=" + date +
                '}';
    }
}
