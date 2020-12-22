package com.oyc.springbootsecurity.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限表(Permission)实体类
 *
 * @author oyc
 * @since 2020-12-22 11:37:23
 */
@Entity
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = 951981292411113969L;
    /**
     * id
     */
    @Id
    private Integer id;
    /**
     * 权限
     */
    private String perms;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private Integer creater;
    /**
     * 修改时间
     */
    private Date updateTime;
}