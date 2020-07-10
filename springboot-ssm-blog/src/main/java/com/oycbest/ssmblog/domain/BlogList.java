package com.oycbest.ssmblog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (BlogList)实体类
 *
 * @author oyc
 * @since 2020-04-29 22:47:13
 */
@Data
public class BlogList implements Serializable {
    private static final long serialVersionUID = 747136226730336827L;
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
}
