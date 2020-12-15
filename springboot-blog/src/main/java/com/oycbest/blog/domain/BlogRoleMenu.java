package com.oycbest.blog.domain;

import java.io.Serializable;

/**
 * 角色与菜单对应关系(BlogRoleMenu)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogRoleMenu implements Serializable {
    private static final long serialVersionUID = -84909088996213912L;
    
    private Long id;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 菜单ID
    */
    private Long menuId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

}