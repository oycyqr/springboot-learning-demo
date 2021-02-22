package com.oycbest.ehcache.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author oyc
 * @Description:用户实体类
 * @date 2018/7/8 22:51
 */
@Entity
@Data
@Table(name = "user")
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
     * 户年龄
     */
    private String age;

    /**
     * 用户性别
     */
    private String sex;
}
