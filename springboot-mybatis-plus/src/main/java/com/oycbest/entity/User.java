package com.oycbest.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SsmUser)实体类
 *
 * @author oyc
 * @since 2020-04-28 23:21:50
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 331645245830355567L;
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 账号
     */
    private String account;
    /**
     * 外号-诨名
     */
    private String nickName;
    /**
     * 星宿
     */
    private String constellation;
    /**
     * 年龄
     */
    private String age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 乐观锁 #OptimisticLockerInnerInterceptor
     * 当要更新一条记录的时候，希望这条记录没有被别人更新
     * 乐观锁实现方式：
     *  取出记录时，获取当前version
     *  更新时，带上这个version
     *  执行更新时， set version = newVersion where version = oldVersion
     *  如果version不对，就更新失败
     */
    @Version
    private Integer version;
}
