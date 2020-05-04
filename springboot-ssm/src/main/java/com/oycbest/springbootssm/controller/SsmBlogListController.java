package com.oycbest.springbootssm.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.springbootssm.domain.SsmBlogList;
import com.oycbest.springbootssm.mapper.SsmBlogListMapper;
import com.oycbest.springbootssm.service.SsmBlogListService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SsmBlogList)表控制层
 *
 * @author oyc
 * @since 2020-04-29 22:47:13
 */
@RestController
@RequestMapping("ssmBlogList")
public class SsmBlogListController {
    /**
     * 服务对象
     */
    @Resource
    private SsmBlogListService ssmBlogListService;

    @Resource
    private SsmBlogListMapper ssmBlogListMapper;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public SsmBlogList selectOne(@PathVariable("id") Integer id) {
        return ssmBlogListService.getById(id);
    }

    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("page")
    public IPage<SsmBlogList> page(Page page) {
        return ssmBlogListService.page(page);
    }

    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<SsmBlogList> list() {
        return ssmBlogListService.list();
    }

    /**
     * 修改数据
     *
     * @param ssmBlogList 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(SsmBlogList ssmBlogList) {
        return ssmBlogListService.save(ssmBlogList);
    }

    /**
     * 新增或修改数据
     *
     * @param ssmBlogList 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(SsmBlogList ssmBlogList) {
        return ssmBlogListService.saveOrUpdate(ssmBlogList);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return ssmBlogListService.removeById(id);
    }

}