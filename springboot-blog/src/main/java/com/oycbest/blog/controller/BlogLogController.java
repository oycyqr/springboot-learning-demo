package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogLog;
import com.oycbest.blog.service.BlogLogService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户操作日志表(BlogLog)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogLog")
public class BlogLogController {
    /**
     * 服务对象
     */
    @Resource
    private BlogLogService blogLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogLog selectOne(@PathVariable("id") Long id) {
        return blogLogService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogLog> list() {
        return blogLogService.list();
    }

    /**
     * 修改数据
     *
     * @param blogLog 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogLog blogLog) {
        return blogLogService.save(blogLog);
    }

    /**
     * 新增或修改数据
     *
     * @param blogLog 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogLog blogLog) {
        return blogLogService.saveOrUpdate(blogLog);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return blogLogService.removeById(id);
    }

}
