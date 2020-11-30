package com.oycbest.springbootjpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author oyc
 * @Description: 用户实体类
 * @date 2018/7/8 22:51
 */
@Entity
@Data
@Table(name = "address_jpa")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class OyAddress implements Serializable {
    private static final long serialVersionUID = 339460670228746792L;

    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户名称
     */
    private String city;

    private String detailAddress;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public OyAddress(String city, String detailAddress, Date createTime) {
        this.city = city;
        this.detailAddress = detailAddress;
        this.createTime = createTime;
    }
}
