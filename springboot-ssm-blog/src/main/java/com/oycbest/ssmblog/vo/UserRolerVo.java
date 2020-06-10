package com.oycbest.ssmblog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/6/3 12:04 上午
 */
@Data
public class UserRolerVo implements Serializable {
    private static final long serialVersionUID = 4858725020512019646L;
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
     * 密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**
     * 角色
     */
    private Set<RolePermissinVo> roles;
}
