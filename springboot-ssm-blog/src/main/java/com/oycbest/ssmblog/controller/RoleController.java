package com.oycbest.ssmblog.controller;

import com.oycbest.ssmblog.domain.Role;
import com.oycbest.ssmblog.service.RoleService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息表(Role)表控制层
 *
 * @author oyc
 * @since 2020-06-02 22:00:50
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
    @GetMapping("{id}")
    public Role selectOne(@PathVariable("id") Integer id) {
        return roleService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping
    public List<Role> list() {
        return roleService.list();
    }

    /**
    * 修改数据
    *
    * @param role 实例对象
    * @return 实例对象
    */
    @PostMapping
    public Boolean save(Role role) {
        return roleService.save(role);
    }

    /**
     * 新增或修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(Role role) {
        return roleService.saveOrUpdate(role);
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
     @Delete("{roleId}")
    public Boolean delete(@PathVariable("roleId")  Integer roleId) {
        return roleService.removeById(roleId);
    }

}
