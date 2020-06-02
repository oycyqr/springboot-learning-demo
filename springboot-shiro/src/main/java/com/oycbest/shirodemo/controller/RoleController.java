package com.oycbest.shirodemo.controller;

import com.oycbest.shirodemo.domain.Role;
import com.oycbest.shirodemo.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息表(Role)表控制层
 *
 * @author oyc
 * @since 2020-06-02 17:06:12
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Role selectOne(Integer id) {
        return this.roleService.queryById(id);
    }
    
    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<Role> list(Integer id) {
        return this.roleService.queryAllByLimit(1,10);
    }

}