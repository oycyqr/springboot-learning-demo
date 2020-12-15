package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogArticleInfo;
import com.oycbest.blog.service.BlogArticleInfoService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章表(BlogArticleInfo)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogArticleInfo")
public class BlogArticleInfoController {
    /**
     * 服务对象
     */
    @Resource
    private BlogArticleInfoService blogArticleInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogArticleInfo selectOne(@PathVariable("id") Long id) {
        return blogArticleInfoService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogArticleInfo> list() {
        return blogArticleInfoService.list();
    }

    /**
     * 修改数据
     *
     * @param blogArticleInfo 实例对象
     * @return 实例对象
     */
    @PostMapping
    public boolean save(BlogArticleInfo blogArticleInfo) {
        return blogArticleInfoService.save(blogArticleInfo);
    }

    /**
     * 新增或修改数据
     *
     * @param blogArticleInfo 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogArticleInfo blogArticleInfo) {
        return blogArticleInfoService.saveOrUpdate(blogArticleInfo);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return blogArticleInfoService.removeById(id);
    }

}
