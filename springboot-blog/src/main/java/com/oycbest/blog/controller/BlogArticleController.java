package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogArticle;
import com.oycbest.blog.service.BlogArticleService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章表(BlogArticle)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:01:16
 */
@RestController
@RequestMapping("blogArticle")
public class BlogArticleController {
    /**
     * 服务对象
     */
    @Resource
    private BlogArticleService blogArticleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogArticle selectOne(@PathVariable("id") Integer id) {
        return blogArticleService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogArticle> list() {
        return blogArticleService.list();
    }

    /**
     * 修改数据
     *
     * @param blogArticle 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogArticle blogArticle) {
        return blogArticleService.save(blogArticle);
    }

    /**
     * 新增或修改数据
     *
     * @param blogArticle 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogArticle blogArticle) {
        return blogArticleService.saveOrUpdate(blogArticle);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return blogArticleService.removeById(id);
    }

}
