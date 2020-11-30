package com.oycbest.springbootshardingsphere.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author oyc
 */
@Data
public class Address implements Serializable {
    private static final long serialVersionUID = -344170839934155324L;
    @TableId
    private String addressId;
    private String address;
}
