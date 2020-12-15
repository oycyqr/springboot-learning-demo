package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogUser;
import com.oycbest.blog.service.BlogUserService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(BlogUser)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogUser")
public class BlogUserController {
    /**
     * 服务对象
     */
    @Resource
    private BlogUserService blogUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogUser selectOne(@PathVariable("id") Integer id) {
        return blogUserService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogUser> list() {
        return blogUserService.list();
    }

    /**
     * 修改数据
     *
     * @param blogUser 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogUser blogUser) {
        return blogUserService.save(blogUser);
    }

    /**
     * 新增或修改数据
     *
     * @param blogUser 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogUser blogUser) {
        return blogUserService.saveOrUpdate(blogUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return blogUserService.removeById(id);
    }

}
