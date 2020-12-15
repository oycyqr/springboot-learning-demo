package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogRolePermission;
import com.oycbest.blog.service.BlogRolePermissionService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BlogRolePermission)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogRolePermission")
public class BlogRolePermissionController {
    /**
     * 服务对象
     */
    @Resource
    private BlogRolePermissionService blogRolePermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogRolePermission selectOne(@PathVariable("id") Integer id) {
        return blogRolePermissionService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogRolePermission> list() {
        return blogRolePermissionService.list();
    }

    /**
     * 修改数据
     *
     * @param blogRolePermission 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogRolePermission blogRolePermission) {
        return blogRolePermissionService.save(blogRolePermission);
    }

    /**
     * 新增或修改数据
     *
     * @param blogRolePermission 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogRolePermission blogRolePermission) {
        return blogRolePermissionService.saveOrUpdate(blogRolePermission);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return blogRolePermissionService.removeById(id);
    }

}
