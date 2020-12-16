package com.oycbest.blog.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户与角色对应关系(BlogUserRole)表实体类
 *
 * @author oyc
 * @since 2020-12-16 11:29:11
 */
@SuppressWarnings("serial")
@Data
public class BlogUserRole extends Model<BlogUserRole> {
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;


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