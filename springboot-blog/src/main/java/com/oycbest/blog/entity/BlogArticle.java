package com.oycbest.blog.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 文章表(BlogArticle)表实体类
 *
 * @author oyc
 * @since 2020-12-16 11:29:04
 */
@SuppressWarnings("serial")
@Data
public class BlogArticle extends Model<BlogArticle> {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 博客ID
     */
    private Integer blogId;

    /**
     * 文章内容txt
     */
    private Object content;

    /**
     * 文章内容html
     */
    private Object contentHtml;


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