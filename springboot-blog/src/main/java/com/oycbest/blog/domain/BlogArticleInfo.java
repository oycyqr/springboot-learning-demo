package com.oycbest.blog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章表(BlogArticleInfo)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogArticleInfo implements Serializable {
    private static final long serialVersionUID = 857973531564219650L;
    /**
    * 主键ID
    */
    private Long id;
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 作者昵称
    */
    private String nickname;
    /**
    * 文章标题
    */
    private String title;
    /**
    * 文章摘要
    */
    private String summary;
    /**
    * 浏览数
    */
    private Integer viewNum;
    /**
    * 文章分类ID
    */
    private Integer categoryId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date saveOrUpdateTime;
    /**
    * 状态
    */
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getsaveOrUpdateTime() {
        return saveOrUpdateTime;
    }

    public void setsaveOrUpdateTime(Date saveOrUpdateTime) {
        this.saveOrUpdateTime = saveOrUpdateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
