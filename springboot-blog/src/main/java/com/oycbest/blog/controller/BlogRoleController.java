package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogRole;
import com.oycbest.blog.service.BlogRoleService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息表(BlogRole)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogRole")
public class BlogRoleController {
    /**
     * 服务对象
     */
    @Resource
    private BlogRoleService blogRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogRole selectOne(@PathVariable("id") Integer id) {
        return blogRoleService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogRole> list() {
        return blogRoleService.list();
    }

    /**
     * 修改数据
     *
     * @param blogRole 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogRole blogRole) {
        return blogRoleService.save(blogRole);
    }

    /**
     * 新增或修改数据
     *
     * @param blogRole 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogRole blogRole) {
        return blogRoleService.saveOrUpdate(blogRole);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{roleId}")
    public Boolean delete(@PathVariable("roleId") Integer id) {
        return blogRoleService.removeById(id);
    }

}
