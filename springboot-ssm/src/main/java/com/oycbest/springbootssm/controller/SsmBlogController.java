package com.oycbest.springbootssm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.springbootssm.domain.SsmBlog;
import com.oycbest.springbootssm.mapper.SsmBlogMapper;
import com.oycbest.springbootssm.service.SsmBlogService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SsmBlog)表控制层
 *
 * @author oyc
 * @since 2020-04-28 23:36:00
 */
@RestController
@RequestMapping("ssmBlog")
public class SsmBlogController {
    /**
     * 服务对象
     */
    @Resource
    private SsmBlogMapper ssmBlogMapper;
    /**
     * 服务对象
     */
    @Resource
    private SsmBlogService ssmBlogService;

    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity list(Page page, SsmBlog blog) {
        //ssmBlogMapper.queryAllByLimit(1,1);
        QueryWrapper<SsmBlog> wrapper = new QueryWrapper<>();
        wrapper.setEntity(blog);
        return ResponseEntity.ok().body(ssmBlogService.page(page, wrapper));
    }

    /**
     * 分页查询数据
     *
     * @return 列表分页数据
     */
    @GetMapping("page")
    public IPage<SsmBlog> page(Page page) {
        return ssmBlogService.queryByPage(page);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键￿
     */
    @GetMapping("{id}")
    public SsmBlog selectOne(@PathVariable("id") Integer id) {
        return ssmBlogService.queryById(id);
    }


    /**
     * 修改数据
     *
     * @param ssmBlog 实例对象
     * @return 实例对象
     */
    @PostMapping
    public SsmBlog save(SsmBlog ssmBlog) {
        return ssmBlogService.insert(ssmBlog);
    }

    /**
     * 新增或修改数据
     *
     * @param ssmBlog 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(SsmBlog ssmBlog) {
        return ssmBlogService.saveOrUpdate(ssmBlog);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return ssmBlogService.deleteById(id);
    }

}