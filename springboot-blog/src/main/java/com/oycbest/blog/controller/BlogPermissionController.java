package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogPermission;
import com.oycbest.blog.service.BlogPermissionService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限表(BlogPermission)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogPermission")
public class BlogPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private BlogPermissionService blogPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogPermission selectOne(@PathVariable("id") Integer id) {
        return blogPermissionService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogPermission> list() {
        return blogPermissionService.list();
    }

    /**
     * 修改数据
     *
     * @param blogPermission 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogPermission blogPermission) {
        return blogPermissionService.save(blogPermission);
    }

    /**
     * 新增或修改数据
     *
     * @param blogPermission 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean aveOrUpdate(BlogPermission blogPermission) {
        return blogPermissionService.saveOrUpdate(blogPermission);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return blogPermissionService.removeById(id);
    }

}
