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

    private Long userId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 原始密码
     */
    private String password;

    /**
     * md5加密后的密码
     */
    private String md5Password;

    /**
     * 原始密码
     */
    private String password1;

    /**
     * aes加密后的密码
     */
    private String aesPassword;

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
    private Date create_time;

}
