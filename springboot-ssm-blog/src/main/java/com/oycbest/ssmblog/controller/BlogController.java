package com.oycbest.ssmblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.ssmblog.domain.Blog;
import com.oycbest.ssmblog.mapper.BlogMapper;
import com.oycbest.ssmblog.service.BlogService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SsmBlog)表控制层
 *
 * @author oyc
 * @since 2020-04-28 23:36:00
 */
@RestController
@RequestMapping("blog/content")
public class BlogController {
    /**
     * 服务对象
     */
    @Resource
    private BlogService blogService;

    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity list(Page page, Blog blog) {
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        wrapper.setEntity(blog);
        return ResponseEntity.ok().body(blogService.page(page, wrapper));
    }

    /**
     * 分页查询数据
     *
     * @return 列表分页数据
     */
    @GetMapping("page")
    public IPage<Blog> page(Page page) {
        return blogService.page(page);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键￿
     */
    @GetMapping("{id}")
    public Blog selectOne(@PathVariable("id") Integer id) {
        return blogService.getById(id);
    }


    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(Blog blog) {
        return blogService.save(blog);
    }

    /**
     * 新增或修改数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(Blog blog) {
        return blogService.saveOrUpdate(blog);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return blogService.removeById(id);
    }

}
