package com.oycbest.blog.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论表(BlogComment)表实体类
 *
 * @author oyc
 * @since 2020-12-16 11:29:07
 */
@SuppressWarnings("serial")
@Data
public class BlogComment extends Model<BlogComment> {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 父评论Id
     */
    private Integer parentId;

    /**
     * 评论的评论用户ID
     */
    private Integer toUid;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


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
