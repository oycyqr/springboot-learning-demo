package com.oycbest.jdbcdemo.domain;


import java.io.Serializable;

/**
 * @author oyc
 * @Description:用户实体类
 * @date 2018/7/8 22:51
 */

public class User implements Serializable {

	//用户id
	private String id;

	//用户名称
	private String name;

	//户年龄
	private String age;

	//用户性别
	private String sex;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
