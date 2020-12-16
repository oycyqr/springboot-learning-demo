package com.oycbest.blog.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色与菜单对应关系(BlogRoleMenu)表实体类
 *
 * @author oyc
 * @since 2020-12-16 11:29:09
 */
@SuppressWarnings("serial")
@Data
public class BlogRoleMenu extends Model<BlogRoleMenu> {
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}