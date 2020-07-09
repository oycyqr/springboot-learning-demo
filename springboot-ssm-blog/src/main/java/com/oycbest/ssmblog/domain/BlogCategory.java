package com.oycbest.ssmblog.domain;

import lombok.*;

import java.util.Date;

/**
 * 文章类别表
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BlogCategory {
    /**
     * 主键ID
     */
    private Long id;

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
}