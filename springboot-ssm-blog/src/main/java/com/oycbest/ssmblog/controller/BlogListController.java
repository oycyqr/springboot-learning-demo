package com.oycbest.ssmblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.ssmblog.domain.BlogList;
import com.oycbest.ssmblog.service.BlogListService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SsmBlogList)表控制层
 *
 * @author oyc
 * @since 2020-04-29 22:47:13
 */
@RestController
@RequestMapping("blog/list")
public class BlogListController {
    /**
     * 服务对象
     */
    @Resource
    private BlogListService blogListService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogList selectOne(@PathVariable("id") Integer id) {
        return blogListService.getById(id);
    }

    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("page")
    public ResponseEntity list(Page page, BlogList blogList) {
        QueryWrapper<BlogList> wrapper = new QueryWrapper<>();
        wrapper.setEntity(blogList);
        return ResponseEntity.ok().body(blogListService.page(page, wrapper));
    }

    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping
    public List<BlogList> list() {
        return blogListService.list();
    }

    /**
     * 修改数据
     *
     * @param blogList 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogList blogList) {
        return blogListService.save(blogList);
    }

    /**
     * 新增或修改数据
     *
     * @param blogList 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogList blogList) {
        return blogListService.saveOrUpdate(blogList);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return blogListService.removeById(id);
    }

}
