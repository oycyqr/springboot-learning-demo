package com.oycbest.blog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(BlogUser)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogUser implements Serializable {
    private static final long serialVersionUID = 857758102241344592L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 登录账号
    */
    private String account;
    /**
    * 密码
    */
    private String password;
    /**
    * 盐
    */
    private String salt;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 手机号
    */
    private String phone;
    /**
    * 上次登录时间
    */
    private Date lastLoginTime;
    /**
    * 用户昵称
    */
    private String nickname;
    /**
    * 用户头像
    */
    private String avatar;
    /**
    * 是否admin，0不是，1是
    */
    private Integer admin;
    /**
    * 用户状态
    */
    private Integer status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date saveOrUpdateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getsaveOrUpdateTime() {
        return saveOrUpdateTime;
    }

    public void setsaveOrUpdateTime(Date saveOrUpdateTime) {
        this.saveOrUpdateTime = saveOrUpdateTime;
    }

}
