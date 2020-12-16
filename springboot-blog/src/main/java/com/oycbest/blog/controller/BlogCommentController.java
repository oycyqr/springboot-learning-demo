package com.oycbest.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.blog.entity.BlogArticle;
import com.oycbest.blog.entity.BlogComment;
import com.oycbest.blog.service.BlogCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 评论表(BlogComment)表控制层
 *
 * @author oyc
 * @since 2020-12-16 11:16:59
 */
@RestController
@RequestMapping("comment")
public class BlogCommentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BlogCommentService blogCommentService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param blogComment 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<BlogComment> page, BlogComment blogComment) {
        return success(this.blogCommentService.page(page, new QueryWrapper<>(blogComment)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogCommentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blogComment 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BlogComment blogComment) {
        return success(this.blogCommentService.save(blogComment));
    }

    /**
     * 修改数据
     *
     * @param blogComment 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody BlogComment blogComment) {
        return success(this.blogCommentService.updateById(blogComment));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Integer> idList) {
        return success(this.blogCommentService.removeByIds(idList));
    }

    /**
     * 根据用户id获取评论列表
     *
     * @param blogId
     * @param page
     * @return
     */
    @GetMapping("blogId/{blogId}")
    public R getCommentByBlogId(@PathVariable Integer blogId, Page<BlogComment> page) {
        BlogComment blogComment = new BlogComment();
        blogComment.setArticleId(blogId);
        return success(this.blogCommentService.page(page, new QueryWrapper<>(blogComment)));
    }

    /**
     * 根据用户id获取评论列表
     *
     * @param userId
     * @param page
     * @return
     */
    @GetMapping("userId/{userId}")
    public R getCommentByUserId(@PathVariable Integer userId, Page<BlogComment> page) {
        BlogComment blogComment = new BlogComment();
        blogComment.setUserId(userId);
        return success(this.blogCommentService.page(page, new QueryWrapper<>(blogComment)));
    }
}
