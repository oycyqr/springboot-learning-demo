package com.oycbest.springbootvalidated.vo;


import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 用户实体类
 * @author oyc
 */
public class User implements Serializable {
    private String userId;

    @NotNull(message = "用户名不能为空")
    private String userName;

    @NotNull(message = "年龄不能为空")
    @Max(value = 100, message = "年龄不能大于100岁")
    private int age;

    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    @NotNull(message = "电话号码不能为空")
    private String phoneNumber;

    public User(@NotNull(message = "用户名不能为空") String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public User() {
    }

    public User(String userId, @NotNull(message = "用户名不能为空") String userName, int age, String email, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
