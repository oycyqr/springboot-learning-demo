package com.oycbest.shirodemo.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * (User)实体类
 *
 * @author oyc
 * @since 2020-04-28 23:21:50
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 331645245830355567L;

    private Integer id;
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
     * 盐值
     */
    private String salt;
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
    private Date createTime;
    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;
}
