package com.oycbest.blog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户操作日志表(BlogLog)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogLog implements Serializable {
    private static final long serialVersionUID = -55503391897454975L;
    /**
    * 主键ID
    */
    private Long id;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 访问Ip
    */
    private String ip;
    /**
    * 操作模块
    */
    private String module;
    /**
    * 访问方法
    */
    private String method;
    /**
    * 方法参数
    */
    private String params;
    /**
    * 操作人昵称
    */
    private String nickname;
    /**
    * 操作事项
    */
    private String operation;
    /**
    * 操作耗时
    */
    private Long time;
    /**
    * 操作用户userId
    */
    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}