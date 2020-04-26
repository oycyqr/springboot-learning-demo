package com.bestoyc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author oyc
 * @Description: 用户实体类
 * @date 2018/7/8 22:51
 */
@Entity
@Table(name = "user_jpa")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class OyUser implements Serializable {
    private static final long serialVersionUID = 339460670228746794L;

    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;
    /**
     * 星宿
     */
    @Column(name = "constellation")
    private String constellation;


    /**
     * 户年龄
     */
    private Integer age;

    /**
     * 用户性别
     */
    private String sex;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	@Override
	public String toString() {
		return "OyUser{" +
				"id=" + id +
				", name='" + name + '\'' +
				", account='" + account + '\'' +
				", nickName='" + nickName + '\'' +
				", constellation='" + constellation + '\'' +
				", age=" + age +
				", sex='" + sex + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
