package com.oycbest.ssmblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.ssmblog.domain.BlogComment;
import com.oycbest.ssmblog.service.BlogCommentService;
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
@RequestMapping("blog/comment")
public class BlogCommentController {
    /**
     * 服务对象
     */
    @Resource
    private BlogCommentService blogCommentService;

    /**
     * 所有文章评论列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity list(Page page, BlogComment blogComment) {
        QueryWrapper<BlogComment> wrapper = new QueryWrapper<>();
        wrapper.setEntity(blogComment);
        return ResponseEntity.ok().body(blogCommentService.page(page, wrapper));
    }

    /**
     * 分页查询数据
     *
     * @return 列表分页数据
     */
    @GetMapping("page")
    public IPage<BlogComment> page(Page page) {
        return blogCommentService.page(page);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键￿
     */
    @GetMapping("{id}")
    public BlogComment selectOne(@PathVariable("id") Integer id) {
        return blogCommentService.getById(id);
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
    public Boolean delete(@PathVariable("id") Long id) {
        return blogCommentService.removeById(id);
    }

}
