package com.oycbest.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.blog.entity.BlogCategory;
import com.oycbest.blog.service.BlogCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 文章类别表(BlogCategory)表控制层
 *
 * @author oyc
 * @since 2020-12-16 11:16:56
 */
@RestController
@RequestMapping("category")
public class BlogCategoryController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BlogCategoryService blogCategoryService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param blogCategory 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<BlogCategory> page, BlogCategory blogCategory) {
        return success(this.blogCategoryService.page(page, new QueryWrapper<>(blogCategory)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogCategoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blogCategory 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BlogCategory blogCategory) {
        return success(this.blogCategoryService.save(blogCategory));
    }

    /**
     * 修改数据
     *
     * @param blogCategory 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody BlogCategory blogCategory) {
        return success(this.blogCategoryService.updateById(blogCategory));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.blogCategoryService.removeByIds(idList));
    }
}