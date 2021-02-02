package com.oycbest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.entity.Blog;
import com.oycbest.service.BlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 文章表(Blog)表控制层
 *
 * @author oyc
 * @since 2021-02-02 11:47:23
 */
@RestController
@RequestMapping("blog")
public class BlogController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BlogService blogService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param blog 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Blog> page, Blog blog) {
        return success(this.blogService.page(page, new QueryWrapper<>(blog)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blog 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Blog blog) {
        return success(this.blogService.save(blog));
    }

    /**
     * 修改数据
     *
     * @param blog 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Blog blog) {
        return success(this.blogService.updateById(blog));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.blogService.removeByIds(idList));
    } /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("logic")
    public R logicDelete(@RequestParam("idList") List<Long> idList) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("deleted", 1);
        updateWrapper.in("id",idList);
        return success(this.blogService.update(updateWrapper));
    }
}
