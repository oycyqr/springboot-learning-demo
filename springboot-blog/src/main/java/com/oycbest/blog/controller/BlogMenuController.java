package com.oycbest.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.blog.entity.BlogMenu;
import com.oycbest.blog.service.BlogMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 菜单权限表(BlogMenu)表控制层
 *
 * @author oyc
 * @since 2020-12-16 11:17:02
 */
@RestController
@RequestMapping("menu")
public class BlogMenuController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BlogMenuService blogMenuService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param blogMenu 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<BlogMenu> page, BlogMenu blogMenu) {
        return success(this.blogMenuService.page(page, new QueryWrapper<>(blogMenu)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogMenuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blogMenu 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BlogMenu blogMenu) {
        return success(this.blogMenuService.save(blogMenu));
    }

    /**
     * 修改数据
     *
     * @param blogMenu 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody BlogMenu blogMenu) {
        return success(this.blogMenuService.updateById(blogMenu));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.blogMenuService.removeByIds(idList));
    }
}