package com.oycbest.blog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 权限表(BlogPermission)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogPermission implements Serializable {
    private static final long serialVersionUID = -78678545071861284L;
    /**
    * id

    */
    private Integer id;
    /**
    * 权限
    */
    private String perms;
    /**
    * 创建人
    */
    private Integer creater;
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

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
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
