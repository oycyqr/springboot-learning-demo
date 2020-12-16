package com.oycbest.blog.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * 文章类别表(BlogCategory)表实体类
 *
 * @author ouyang
 * @since 2020-12-16 23:11:07
 */
@SuppressWarnings("serial")
@Data
public class BlogCategory extends Model<BlogCategory> {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

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
    private Date updateTime;

    /**
     * 状态
     */
    private Integer status;


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
