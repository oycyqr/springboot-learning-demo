package com.oycbest.ssmblog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * (SsmUser)实体类
 *
 * @author oyc
 * @since 2020-04-28 23:21:50
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 331645245830355567L;

    private Integer id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    private String account;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
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
     * 创建时间 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

}
