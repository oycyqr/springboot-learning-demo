package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogUserRole;
import com.oycbest.blog.service.BlogUserRoleService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户与角色对应关系(BlogUserRole)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogUserRole")
public class BlogUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private BlogUserRoleService blogUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogUserRole selectOne(@PathVariable("id") Long id) {
        return blogUserRoleService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogUserRole> list() {
        return blogUserRoleService.list();
    }

    /**
     * 修改数据
     *
     * @param blogUserRole 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogUserRole blogUserRole) {
        return blogUserRoleService.save(blogUserRole);
    }

    /**
     * 新增或修改数据
     *
     * @param blogUserRole 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogUserRole blogUserRole) {
        return blogUserRoleService.saveOrUpdate(blogUserRole);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return blogUserRoleService.removeById(id);
    }

}
