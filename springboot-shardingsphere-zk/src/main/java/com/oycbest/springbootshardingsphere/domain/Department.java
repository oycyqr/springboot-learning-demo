package com.oycbest.springbootshardingsphere.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author oyc
 */
@Data
public class Department implements Serializable {
    private static final long serialVersionUID = -344170839934155324L;
    private String deptId;
    private String deptName;
    private String deptAdmin;

}
