package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogTag;
import com.oycbest.blog.service.BlogTagService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签表(BlogTag)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogTag")
public class BlogTagController {
    /**
     * 服务对象
     */
    @Resource
    private BlogTagService blogTagService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogTag selectOne(@PathVariable("id") Integer id) {
        return blogTagService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogTag> list() {
        return blogTagService.list();
    }

    /**
     * 修改数据
     *
     * @param blogTag 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogTag blogTag) {
        return blogTagService.save(blogTag);
    }

    /**
     * 新增或修改数据
     *
     * @param blogTag 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogTag blogTag) {
        return blogTagService.saveOrUpdate(blogTag);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return blogTagService.removeById(id);
    }

}
