package com.oyc.springbootsecurity.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "permission_id") })
    private Set<Permission> permissions = new HashSet<>();

}