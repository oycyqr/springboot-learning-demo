package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogRoleMenu;
import com.oycbest.blog.service.BlogRoleMenuService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色与菜单对应关系(BlogRoleMenu)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogRoleMenu")
public class BlogRoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private BlogRoleMenuService blogRoleMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogRoleMenu selectOne(@PathVariable("id") Long id) {
        return blogRoleMenuService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogRoleMenu> list() {
        return blogRoleMenuService.list();
    }

    /**
     * 修改数据
     *
     * @param blogRoleMenu 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogRoleMenu blogRoleMenu) {
        return blogRoleMenuService.save(blogRoleMenu);
    }

    /**
     * 新增或修改数据
     *
     * @param blogRoleMenu 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogRoleMenu blogRoleMenu) {
        return blogRoleMenuService.saveOrUpdate(blogRoleMenu);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return blogRoleMenuService.removeById(id);
    }

}
