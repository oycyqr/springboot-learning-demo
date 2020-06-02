package com.oycbest.ssmblog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (SsmBlog)实体类
 *
 * @author oyc
 * @since 2020-04-28 23:36:00
 */
@Data
public class Blog implements Serializable {
    private static final long serialVersionUID = 919419604545386949L;
    /**
    * id
    */
    private Integer id;
    /**
    * 标题
    */
    private String title;
    /**
    * 概述
    */
    private String summary;
    /**
    * 链接地址
    */
    private String url;
    /**
    * 内容html
    */
    private String contentHtml;
    /**
    * 发布时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date pubdate;
    /**
    * 记录创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 文章text
    */
    private String contentText;
}
