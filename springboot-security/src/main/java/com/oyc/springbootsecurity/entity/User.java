package com.oyc.springbootsecurity.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName: User
 * @Description: User
 * @Author oyc
 * @Date 2020/12/21 15:31
 * @Version 1.0
 */
@Entity
@Data
public class User {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;
}