package com.oycbest.blog.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签表(BlogTag)表实体类
 *
 * @author oyc
 * @since 2020-12-16 11:29:10
 */
@SuppressWarnings("serial")
@Data
public class BlogTag extends Model<BlogTag> {

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 状态
     */
    private Object status;


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