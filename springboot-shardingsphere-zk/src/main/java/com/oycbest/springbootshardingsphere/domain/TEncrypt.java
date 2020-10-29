package com.oycbest.springbootshardingsphere.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: (User)实体类
 * @Author oyc
 * @Date 2020/10/24 16:36
 * @Version 1.0
 */
@Data
public class TEncrypt implements Serializable {

    private static final long serialVersionUID = 358157380505039579L;

    private String userId;

    private String orderId;

}
