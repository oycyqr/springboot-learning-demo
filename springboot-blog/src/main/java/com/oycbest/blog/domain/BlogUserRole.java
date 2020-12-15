package com.oycbest.blog.domain;

import java.io.Serializable;

/**
 * 用户与角色对应关系(BlogUserRole)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogUserRole implements Serializable {
    private static final long serialVersionUID = 350168994109216876L;
    
    private Long id;
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 角色ID
    */
    private Long roleId;


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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}