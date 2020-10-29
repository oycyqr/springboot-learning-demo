package com.oycbest.springbootshardingsphere.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Description: (User)实体类
 * @Author oyc
 * @Date 2020/10/24 16:36
 * @Version 1.0
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 358157380505039579L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 地址
     */
    private String addressId;

}
