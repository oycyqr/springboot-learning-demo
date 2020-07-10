package com.oycbest.ssmblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.ssmblog.domain.BlogCategory;
import com.oycbest.ssmblog.service.BlogCategoryService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BlogArticle)表控制层
 *
 * @author oyc
 * @since 2020-04-28 23:36:00
 */
@RestController
@RequestMapping("blog/category")
public class BlogCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private BlogCategoryService categoryService;

    /**
     * 所有文章分类列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity list(Page page, BlogCategory category ) {
        QueryWrapper<BlogCategory> wrapper = new QueryWrapper<>();
        wrapper.setEntity(category);
        return ResponseEntity.ok().body(categoryService.page(page, wrapper));
    }

    /**
     * 分页查询数据
     *
     * @return 列表分页数据
     */
    @GetMapping("page")
    public IPage<BlogCategory> page(Page page) {
        return categoryService.page(page);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键￿
     */
    @GetMapping("{id}")
    public BlogCategory selectOne(@PathVariable("id") Integer id) {
        return categoryService.getById(id);
    }


    /**
     * 修改数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogCategory category) {
        return categoryService.save(category);
    }

    /**
     * 新增或修改数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogCategory category) {
        return categoryService.saveOrUpdate(category);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return categoryService.removeById(id);
    }

}
