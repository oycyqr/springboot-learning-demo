package com.oycbest.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.blog.entity.BlogTag;
import com.oycbest.blog.service.BlogTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 标签表(BlogTag)表控制层
 *
 * @author oyc
 * @since 2020-12-16 11:17:09
 */
@RestController
@RequestMapping("tag")
public class BlogTagController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BlogTagService blogTagService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param blogTag 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<BlogTag> page, BlogTag blogTag) {
        return success(this.blogTagService.page(page, new QueryWrapper<>(blogTag)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogTagService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blogTag 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BlogTag blogTag) {
        return success(this.blogTagService.save(blogTag));
    }

    /**
     * 修改数据
     *
     * @param blogTag 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody BlogTag blogTag) {
        return success(this.blogTagService.updateById(blogTag));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.blogTagService.removeByIds(idList));
    }
}