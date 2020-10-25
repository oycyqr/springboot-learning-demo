package com.oycbest.springbootshardingsphere.controller;

import com.oycbest.springbootshardingsphere.domain.User;
import com.oycbest.springbootshardingsphere.mapper.UserMapper;
import org.apache.shardingsphere.api.hint.HintManager;
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
@RequestMapping("test")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * user mapper
     */
    @Resource
    private UserMapper userMapper;

    /**
     * 用户列表
     */
    @RequestMapping
    public List<User> userList() {
        logger.info("********TestController userList()");
        List<User> users = userMapper.selectList(null);
        return users;
    }

/**
 * 用户列表,强制路由主库
 */
@RequestMapping("ds0")
public List<User> userListDs0() {
    logger.info("********TestController userListDs0():强制路由主库");

    HintManager hintManager = HintManager.getInstance();
    List<User> users = userMapper.selectList(null);

    //清除分片键值，分片键值保存在ThreadLocal中，所以需要在操作结束时调用hintManager.close()来清除ThreadLocal中的内容。hintManager实现了AutoCloseable接口，可推荐使用try with resource自动关闭。
    hintManager.close();
    List<User> users1 = userMapper.selectList(null);
    users.addAll(users1);
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
}