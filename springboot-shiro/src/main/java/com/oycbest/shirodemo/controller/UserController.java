package com.oycbest.shirodemo.controller;

import com.oycbest.shirodemo.domain.User;
import com.oycbest.shirodemo.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
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
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.queryById(id);
    }
    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping
    public List<User> userList() {
        return userService.queryAll();
    }

    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<User> list() {
        return userService.queryAllByLimit(1,10);
    }

    /**
    * 修改数据
    *
    * @param ssmUser 实例对象
    * @return 实例对象
    */
    @PostMapping
    public User save(User ssmUser) {
        return userService.insert(ssmUser);
    }

    /**
     * 新增或修改数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @PutMapping
    public User saveOrUpdate(User ssmUser) {
        if (ssmUser.getId() != null) {
            return userService.update(ssmUser);
        } else {
            return userService.insert(ssmUser);
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
     @Delete("{id}")
    public Boolean delete(@PathVariable("id")  Integer id) {
        return userService.deleteById(id);
    }

}
