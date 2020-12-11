package com.oycbest.activiti.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SsmUser)实体类
 *
 * @author oyc
 * @since 2020-04-28 23:21:50
 */
@Data
@TableName("user")
public class SsmUser implements Serializable {
    private static final long serialVersionUID = 331645245830355567L;

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
}
