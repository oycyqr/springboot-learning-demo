package com.oycbest.blog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章类别表(BlogCategory)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogCategory implements Serializable {
    private static final long serialVersionUID = -81129724357028659L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 类别名字
    */
    private String categoryName;
    /**
    * 类别图标
    */
    private String avatar;
    /**
    * 分类描述
    */
    private String description;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date saveOrUpdateTime;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
