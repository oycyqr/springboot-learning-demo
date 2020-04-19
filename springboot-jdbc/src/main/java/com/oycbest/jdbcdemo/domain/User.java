package com.oycbest.jdbcdemo.domain;


import java.io.Serializable;

/**
 * @author oyc
 * @Description:用户实体类
 * @date 2018/7/8 22:51
 */

public class User implements Serializable {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 户年龄
     */
    private int age;

    /**
     * 用户性别
     */
    private String sex;

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

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
