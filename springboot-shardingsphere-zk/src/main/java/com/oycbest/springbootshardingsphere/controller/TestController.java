package com.oycbest.springbootshardingsphere.controller;

import com.oycbest.springbootshardingsphere.domain.User;
import com.oycbest.springbootshardingsphere.mapper.UserMapper;
import com.oycbest.springbootshardingsphere.mapper.UserMasterSlaveMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class TestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserMasterSlaveMapper userMasterSlaveMapper;


    /**
     * 用户列表
     *
     * @return
     */
    @RequestMapping
    public List userAddressList() {
        logger.info("********TestController userList()");
        List<User> users = userMapper.selectList(null);
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
        int insert = userMapper.insert(user);
        return user;
    }

    /**
     * 用户列表
     *
     * @return
     */
    @RequestMapping("ms")
    public List masterSlaveList() {
        logger.info("********TestController userList()");
        List users = userMasterSlaveMapper.selectList(null);
        return users;
    }
}