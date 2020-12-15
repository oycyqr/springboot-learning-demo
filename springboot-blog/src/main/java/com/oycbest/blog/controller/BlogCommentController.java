package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogComment;
import com.oycbest.blog.service.BlogCommentService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表(BlogComment)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogComment")
public class BlogCommentController {
    /**
     * 服务对象
     */
    @Resource
    private BlogCommentService blogCommentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogComment selectOne(@PathVariable("id") Long id) {
        return blogCommentService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogComment> list() {
        return blogCommentService.list();
    }

    /**
    * 修改数据
    *
    * @param blogComment 实例对象
    * @return 实例对象
    */
    @PostMapping
    public Boolean save(BlogComment blogComment) {
        return blogCommentService.save(blogComment);
    }

    /**
     * 新增或修改数据
     *
     * @param blogComment 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogComment blogComment) {
        return blogCommentService.saveOrUpdate(blogComment);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
     @Delete("{id}")
    public Boolean delete(@PathVariable("id")  Long id) {
        return blogCommentService.removeById(id);
    }

}
