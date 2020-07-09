package com.oycbest.ssmblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.ssmblog.domain.BlogArticle;
import com.oycbest.ssmblog.service.BlogArticleService;
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
@RequestMapping("blog/article")
public class BlogArticleController {
    /**
     * 服务对象
     */
    @Resource
    private BlogArticleService blogArticleService;

    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity list(Page page, BlogArticle blog) {
        QueryWrapper<BlogArticle> wrapper = new QueryWrapper<>();
        wrapper.setEntity(blog);
        return ResponseEntity.ok().body(blogArticleService.page(page, wrapper));
    }

    /**
     * 分页查询数据
     *
     * @return 列表分页数据
     */
    @GetMapping("page")
    public IPage<BlogArticle> page(Page page) {
        return blogArticleService.page(page);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键￿
     */
    @GetMapping("{id}")
    public BlogArticle selectOne(@PathVariable("id") Integer id) {
        return blogArticleService.getById(id);
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
    public Boolean delete(@PathVariable("id") Long id) {
        return blogArticleService.removeById(id);
    }

}
