package com.oyc.springbootsecurity.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 角色信息表(Role)实体类
 *
 * @author oyc
 * @since 2020-12-22 11:37:23
 */
@Entity
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -92339096217249817L;
    /**
     * 角色ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色权限字符串
     */
    private String roleKey;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "roleId"))
//    private List<User> userList;
}