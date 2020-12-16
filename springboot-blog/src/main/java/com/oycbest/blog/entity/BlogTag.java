package com.oycbest.blog.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * 标签表(BlogTag)表实体类
 *
 * @author ouyang
 * @since 2020-12-16 23:13:00
 */
@SuppressWarnings("serial")
@Data
public class BlogTag extends Model<BlogTag> {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 创建人id
     */
    private Integer userId;

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
