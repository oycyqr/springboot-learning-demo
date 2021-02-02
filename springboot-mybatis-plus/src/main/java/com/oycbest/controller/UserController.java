package com.oycbest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.domain.User;
import com.oycbest.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SsmUser)表控制层
 *
 * @author oyc
 * @since 2020-04-28 23:24:43
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity selectOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(userService.getById(id));
    }

    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping
    public ResponseEntity list(User user,
                               @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.setEntity(user);
        IPage<User> pageList = userService.page(page, wrapper);
        return ResponseEntity.ok().body(pageList);
    }

    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(userService.list());
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @PostMapping
    public ResponseEntity save(User user) {
        return ResponseEntity.ok().body(userService.save(user));
    }

    /**
     * 新增或修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @PutMapping
    public ResponseEntity saveOrUpdate(User user) {
        return ResponseEntity.ok().body(userService.saveOrUpdate(user));
    }


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(userService.removeById(id));
    }

}
