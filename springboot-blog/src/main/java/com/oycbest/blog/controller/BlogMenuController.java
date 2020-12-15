package com.oycbest.blog.controller;

import com.oycbest.blog.domain.BlogMenu;
import com.oycbest.blog.service.BlogMenuService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单权限表(BlogMenu)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("blogMenu")
public class BlogMenuController {
    /**
     * 服务对象
     */
    @Resource
    private BlogMenuService blogMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BlogMenu selectOne(@PathVariable("id") Integer id) {
        return blogMenuService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<BlogMenu> list() {
        return blogMenuService.list();
    }

    /**
     * 修改数据
     *
     * @param blogMenu 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(BlogMenu blogMenu) {
        return blogMenuService.save(blogMenu);
    }

    /**
     * 新增或修改数据
     *
     * @param blogMenu 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(BlogMenu blogMenu) {
        return blogMenuService.saveOrUpdate(blogMenu);
    }

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    @Delete("{menuId}")
    public Boolean delete(@PathVariable("menuId") Integer menuId) {
        return blogMenuService.removeById(menuId);
    }

}
