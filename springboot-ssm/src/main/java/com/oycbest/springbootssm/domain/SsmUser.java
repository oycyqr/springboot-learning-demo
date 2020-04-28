package com.oycbest.springbootssm.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * (SsmUser)实体类
 *
 * @author oyc
 * @since 2020-04-28 23:21:50
 */
public class SsmUser implements Serializable {
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}