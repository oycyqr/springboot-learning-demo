package com.oycbest.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.blog.entity.BlogArticleTag;
import com.oycbest.blog.service.BlogArticleTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 文章标签表(BlogArticleTag)表控制层
 *
 * @author oyc
 * @since 2020-12-16 11:16:55
 */
@RestController
@RequestMapping("articleTag")
public class BlogArticleTagController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BlogArticleTagService blogArticleTagService;

    /**
     * 分页查询所有数据
     *
     * @param page           分页对象
     * @param blogArticleTag 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<BlogArticleTag> page, BlogArticleTag blogArticleTag) {
        return success(this.blogArticleTagService.page(page, new QueryWrapper<>(blogArticleTag)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogArticleTagService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blogArticleTag 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BlogArticleTag blogArticleTag) {
        return success(this.blogArticleTagService.save(blogArticleTag));
    }

    /**
     * 修改数据
     *
     * @param blogArticleTag 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody BlogArticleTag blogArticleTag) {
        return success(this.blogArticleTagService.updateById(blogArticleTag));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.blogArticleTagService.removeByIds(idList));
    }
}