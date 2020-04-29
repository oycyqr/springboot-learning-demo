package com.oycbest.springbootssm.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * (SsmBlogList)实体类
 *
 * @author oyc
 * @since 2020-04-29 22:47:13
 */
public class SsmBlogList implements Serializable {
    private static final long serialVersionUID = 747136226730336827L;
    /**
    * id
    */
    private Integer id;
    /**
    * 标题
    */
    private String title;
    /**
    * 概述
    */
    private String summary;
    /**
    * 链接地址
    */
    private String url;
    /**
    * 发布时间
    */
    private Date pubdate;
    /**
    * 记录创建时间
    */
    private Date createTime;
    /**
    * 状态
    */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}