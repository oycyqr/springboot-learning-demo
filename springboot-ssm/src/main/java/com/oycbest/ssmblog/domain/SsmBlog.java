package com.oycbest.ssmblog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * (SsmBlog)实体类
 *
 * @author oyc
 * @since 2020-04-28 23:36:00
 */
public class SsmBlog implements Serializable {
    private static final long serialVersionUID = 919419604545386949L;
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
    * 内容html
    */
    private String contentHtml;
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
    /**
    * 文章text
    */
    private String contentText;


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

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
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

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

}
