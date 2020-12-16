package com.oycbest.blog.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户操作日志表(BlogLog)表实体类
 *
 * @author oyc
 * @since 2020-12-16 11:29:08
 */
@SuppressWarnings("serial")
@Data
public class BlogLog extends Model<BlogLog> {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 访问Ip
     */
    private String ip;

    /**
     * 操作模块
     */
    private String module;

    /**
     * 访问方法
     */
    private String method;

    /**
     * 方法参数
     */
    private String params;

    /**
     * 操作人昵称
     */
    private String nickname;

    /**
     * 操作事项
     */
    private String operation;

    /**
     * 操作耗时
     */
    private Long time;

    /**
     * 操作用户userId
     */
    private Long userId;


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