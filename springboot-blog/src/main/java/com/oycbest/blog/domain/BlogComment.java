package com.oycbest.blog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 评论表(BlogComment)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogComment implements Serializable {
    private static final long serialVersionUID = 683694102161633922L;
    /**
    * 主键ID
    */
    private Long id;
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 文章ID
    */
    private Long articleId;
    /**
    * 评论内容
    */
    private String content;
    /**
    * 父评论Id
    */
    private Long parentId;
    /**
    * 评论的评论用户ID
    */
    private Long toUid;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getToUid() {
        return toUid;
    }

    public void setToUid(Long toUid) {
        this.toUid = toUid;
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
