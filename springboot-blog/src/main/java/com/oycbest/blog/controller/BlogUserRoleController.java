package com.oycbest.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.blog.entity.BlogUserRole;
import com.oycbest.blog.service.BlogUserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户与角色对应关系(BlogUserRole)表控制层
 *
 * @author oyc
 * @since 2020-12-16 11:17:13
 */
@RestController
@RequestMapping("userRole")
public class BlogUserRoleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BlogUserRoleService blogUserRoleService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param blogUserRole 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<BlogUserRole> page, BlogUserRole blogUserRole) {
        return success(this.blogUserRoleService.page(page, new QueryWrapper<>(blogUserRole)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogUserRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blogUserRole 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BlogUserRole blogUserRole) {
        return success(this.blogUserRoleService.save(blogUserRole));
    }

    /**
     * 修改数据
     *
     * @param blogUserRole 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody BlogUserRole blogUserRole) {
        return success(this.blogUserRoleService.updateById(blogUserRole));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.blogUserRoleService.removeByIds(idList));
    }
}