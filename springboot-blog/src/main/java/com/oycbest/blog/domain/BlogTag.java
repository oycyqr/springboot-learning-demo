package com.oycbest.blog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 标签表(BlogTag)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogTag implements Serializable {
    private static final long serialVersionUID = 617703881482753080L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 标签名字
    */
    private String tagName;
    /**
    * 标签图标
    */
    private String avatar;
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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
