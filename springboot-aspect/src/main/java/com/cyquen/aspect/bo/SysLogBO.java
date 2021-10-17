package com.cyquen.aspect.bo;

import java.util.Date;
import java.util.StringJoiner;

public class SysLogBO {

    private String className;

    private String methodName;

    private String params;

    private Long execTime;

    private String remark;

    private Date createDate;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getExecTime() {
        return execTime;
    }

    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysLogBO.class.getSimpleName() + "[", "]")
                .add("className='" + className + "'")
                .add("methodName='" + methodName + "'")
                .add("params='" + params + "'")
                .add("execTime=" + execTime)
                .add("remark='" + remark + "'")
                .add("createDate=" + createDate)
                .toString();
    }
}
