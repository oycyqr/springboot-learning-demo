package com.oycbest.springbootshardingsphere.controller;

import com.oycbest.springbootshardingsphere.domain.Department;
import com.oycbest.springbootshardingsphere.mapper.DepartmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DepartmentController
 * @Description DepartmentController
 * @Author oyc
 * @Date 2020/10/24 16:56
 * @Version
 */
@RestController
@RequestMapping("dept")
public class DepartmentController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * deptMapper
     */
    @Resource
    private DepartmentMapper deptMapper;

    /**
     * 部门列表
     *
     * @return
     */
    @RequestMapping
    public List deptList() {
        logger.info("********TestController userList()");
        List<Department> departments = deptMapper.selectList(null);
        return departments;
    }

    /**
     * 保存
     *
     * @return
     */
    @PostMapping
    public Department save(Department department) {
        logger.info("********save department");
        deptMapper.insert(department);
        return department;
    }
}