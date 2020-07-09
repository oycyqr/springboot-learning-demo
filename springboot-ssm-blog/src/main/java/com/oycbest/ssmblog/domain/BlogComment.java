package com.oycbest.ssmblog.domain;

import lombok.*;

import java.util.Date;

/**
 * 评论表
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BlogComment {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 父评论Id
     */
    private Long parentId;

    /**
     * 评论的评论用户ID
     */
    private Long toUid;

    /**
     * 评论级别
     */
    private String levelFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}