package com.oycbest.ssmblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.ssmblog.domain.BlogArticleTag;
import com.oycbest.ssmblog.service.BlogArticleTagService;
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
@RequestMapping("blog/article/tag")
public class BlogArticleTagController {
    /**
     * 服务对象
     */
    @Resource
    private BlogArticleTagService articleTagService;

    /**
     * 所有文章标签列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity list(Page page, BlogArticleTag articleTag) {
        QueryWrapper<BlogArticleTag> wrapper = new QueryWrapper<>();
        wrapper.setEntity(articleTag);
        return ResponseEntity.ok().body(articleTagService.page(page, wrapper));
    }

    /**
     * 分页查询数据
     *
     * @return 列表分页数据
     */
    @GetMapping("page")
    public IPage<BlogArticleTag> page(Page page) {
        return articleTagService.page(page);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键￿
     */
    @GetMapping("{id}")
    public BlogArticleTag selectOne(@PathVariable("id") Integer id) {
        return articleTagService.getById(id);
    }


    /**
     * 修改数据
     *
     * @param articleTag 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogArticleTag articleTag) {
        return articleTagService.save(articleTag);
    }

    /**
     * 新增或修改数据
     *
     * @param articleTag 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogArticleTag articleTag) {
        return articleTagService.saveOrUpdate(articleTag);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return articleTagService.removeById(id);
    }

}
