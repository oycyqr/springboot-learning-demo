package com.oycbest.blog.domain;

import java.io.Serializable;

/**
 * 文章表(BlogArticle)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:01:09
 */
public class BlogArticle implements Serializable {
    private static final long serialVersionUID = 208415789790090657L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 博客ID
    */
    private Integer blogId;
    /**
    * 文章内容txt
    */
    private Object content;
    /**
    * 文章内容html
    */
    private Object contentHtml;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Object getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(Object contentHtml) {
        this.contentHtml = contentHtml;
    }

}