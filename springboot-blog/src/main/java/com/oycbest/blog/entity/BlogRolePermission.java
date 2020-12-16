package com.oycbest.blog.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (BlogRolePermission)表实体类
 *
 * @author oyc
 * @since 2020-12-16 11:29:10
 */
@SuppressWarnings("serial")
@Data
public class BlogRolePermission extends Model<BlogRolePermission> {
    private Integer id;
    private Integer roleId;
    private Integer permissionId;


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