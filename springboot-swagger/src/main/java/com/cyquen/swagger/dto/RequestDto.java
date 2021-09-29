package com.cyquen.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zheng
 */
@ApiModel(value = "requestDto")
public class RequestDto {

    @ApiModelProperty(value = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
