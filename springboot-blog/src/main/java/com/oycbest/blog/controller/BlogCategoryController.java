package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogCategory;
import com.oycbest.blog.service.BlogCategoryService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章类别表(BlogCategory)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogCategory")
public class BlogCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private BlogCategoryService blogCategoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogCategory selectOne(@PathVariable("id") Integer id) {
        return blogCategoryService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogCategory> list() {
        return blogCategoryService.list();
    }

    /**
     * 修改数据
     *
     * @param blogCategory 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogCategory blogCategory) {
        return blogCategoryService.save(blogCategory);
    }

    /**
     * 新增或修改数据
     *
     * @param blogCategory 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogCategory blogCategory) {
        return blogCategoryService.saveOrUpdate(blogCategory);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return blogCategoryService.removeById(id);
    }

}
