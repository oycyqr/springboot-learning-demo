package com.oycbest.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.blog.entity.BlogRoleMenu;
import com.oycbest.blog.service.BlogRoleMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 角色与菜单对应关系(BlogRoleMenu)表控制层
 *
 * @author oyc
 * @since 2020-12-16 11:17:07
 */
@RestController
@RequestMapping("roleMenu")
public class BlogRoleMenuController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BlogRoleMenuService blogRoleMenuService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param blogRoleMenu 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<BlogRoleMenu> page, BlogRoleMenu blogRoleMenu) {
        return success(this.blogRoleMenuService.page(page, new QueryWrapper<>(blogRoleMenu)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogRoleMenuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blogRoleMenu 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BlogRoleMenu blogRoleMenu) {
        return success(this.blogRoleMenuService.save(blogRoleMenu));
    }

    /**
     * 修改数据
     *
     * @param blogRoleMenu 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody BlogRoleMenu blogRoleMenu) {
        return success(this.blogRoleMenuService.updateById(blogRoleMenu));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.blogRoleMenuService.removeByIds(idList));
    }
}