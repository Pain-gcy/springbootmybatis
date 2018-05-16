package com.imooc.springbootmybatis.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author E470
 * @create 2018 - 05 - 14 15:24
 */
@Component
public class Area implements Serializable{

    private Integer id;

    private String areaName;

    private String areaCode;

    private String createTime;

    private String lastEditTime;

    public Area() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(String lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", areaName='" + areaName + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", createTime='" + createTime + '\'' +
                ", lastEditTime='" + lastEditTime + '\'' +
                '}';
    }
}
