package com.oycbest.blog.domain;

import java.io.Serializable;

/**
 * (BlogRolePermission)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogRolePermission implements Serializable {
    private static final long serialVersionUID = -13721540935322101L;
    
    private Integer id;
    
    private Integer roleId;
    
    private Integer permissionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

}