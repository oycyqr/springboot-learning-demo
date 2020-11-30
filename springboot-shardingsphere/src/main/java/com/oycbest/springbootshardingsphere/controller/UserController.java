package com.oycbest.springbootshardingsphere.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oycbest.springbootshardingsphere.domain.User;
import com.oycbest.springbootshardingsphere.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * user mapper
     */
    @Resource
    private UserMapper userMapper;

    /**
     * 用户列表
     * @return
     */
    @RequestMapping
    public List<User> userList() {
        logger.info("********TestController userList()");
        List<User> users = userMapper.selectList(null);
        return users;
    }

    /**
     * 保存用户
     * @return
     */
    @PostMapping
    public User save(User user) {
        logger.info("********save User");
        //user.setUserId(SnowflakeId.getId());
        userMapper.insert(user);
        return user;
    }

    /**
     * 查询用户
     * @return
     */
    @GetMapping("list")
    public Object getUser(User user) {
        logger.info("********s查询用户");
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(user);
        queryWrapper.orderByAsc("user_id");
        return userMapper.selectList(queryWrapper);
    }
}