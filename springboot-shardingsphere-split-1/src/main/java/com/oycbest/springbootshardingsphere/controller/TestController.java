package com.oycbest.springbootshardingsphere.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oycbest.springbootshardingsphere.domain.User;
import com.oycbest.springbootshardingsphere.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName TestController
 * @Description TestController
 * @Author oyc
 * @Date 2020/10/24 16:56
 * @Version
 */
@RestController
@RequestMapping("user")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * user Service
     */
    @Resource
    private UserService userService;

    /**
     * 用户列表
     *
     * @return
     */
    @RequestMapping
    public List userList() {
        logger.info("********TestController userList()");
        List users = userService.list();
        return users;
    }

    /**
     * 用户_地址列表
     *
     * @return
     */
    @RequestMapping("ua")
    public List userAddressList() {
        logger.info("********TestController userList()");
        List<User> users = userService.getUserAddressList();
        return users;
    }

    /**
     * 保存用户
     *
     * @return
     */
    @PostMapping
    public User save(User user) {
        logger.info("********save User");
        Boolean insert = userService.save(user);
        return user;
    }

    /**
     * 按id查询用户
     *
     * @return
     */
    @GetMapping("userId")
    public Object getUserById(Long userId) {
        logger.info("********save User： " + userId);
        User user = new User();
        user.setUserId(userId);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return userService.getById(userId);
    }

    /**
     * 按id查询用户
     *
     * @return
     */
    @GetMapping("userId/in")
    public Object getUserByIdRange(String userId) {
        logger.info("********save User ");
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        List<Long> longIds = new ArrayList<>();

        Arrays.stream(userId.split(",")).forEach(id -> longIds.add(Long.parseLong(id)));

        wrapper.in("user_id", longIds);
        return userService.list(wrapper);
    }


    /**
     * 按id查询用户
     *
     * @return
     */
    @GetMapping("list")
    public Object getUserList(User user) {
        logger.info("********getUserList  ");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.setEntity(user);
        wrapper.orderByAsc("user_id");
        return userService.list(wrapper);
    }
}