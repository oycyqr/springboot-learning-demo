package com.oycbest.blog.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限表(BlogPermission)表实体类
 *
 * @author oyc
 * @since 2020-12-16 11:29:09
 */
@SuppressWarnings("serial")
@Data
public class BlogPermission extends Model<BlogPermission> {

    /**
     * id
     */
    private Integer id;

    /**
     * 权限
     */
    private String perms;

    /**
     * 创建人
     */
    private Integer creater;

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