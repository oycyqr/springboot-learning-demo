package com.oycbest.blog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章标签表(BlogArticleTag)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogArticleTag implements Serializable {
    private static final long serialVersionUID = 580028867808095993L;
    /**
    * 主键ID
    */
    private Long id;
    /**
    * 文章ID
    */
    private Long articleId;
    /**
    * 标签ID
    */
    private Integer tagId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date saveOrUpdateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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

}
