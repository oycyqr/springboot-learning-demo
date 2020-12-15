package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogArticleTag;
import com.oycbest.blog.service.BlogArticleTagService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章标签表(BlogArticleTag)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogArticleTag")
public class BlogArticleTagController {
    /**
     * 服务对象
     */
    @Resource
    private BlogArticleTagService blogArticleTagService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogArticleTag selectOne(@PathVariable("id") Long id) {
        return blogArticleTagService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogArticleTag> list() {
        return blogArticleTagService.list();
    }

    /**
    * 修改数据
    *
    * @param blogArticleTag 实例对象
    * @return 实例对象
    */
    @PostMapping
    public Boolean save(BlogArticleTag blogArticleTag) {
        return blogArticleTagService.save(blogArticleTag);
    }

    /**
     * 新增或修改数据
     *
     * @param blogArticleTag 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogArticleTag blogArticleTag) {
        if (blogArticleTag.getId() != null) {
            return blogArticleTagService.saveOrUpdate(blogArticleTag);
        } else {
            return blogArticleTagService.saveOrUpdate(blogArticleTag);
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
     @Delete("{id}")
    public Boolean delete(@PathVariable("id")  Long id) {
        return blogArticleTagService.removeById(id);
    }

}
