package com.oycbest.springbootshardingsphere.controller;

import cn.hutool.core.util.IdUtil;
import com.oycbest.springbootshardingsphere.domain.User;
import com.oycbest.springbootshardingsphere.mapper.UserMapper;
import com.oycbest.springbootshardingsphere.util.SnowflakeId;
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
@RequestMapping("test" )
public class TestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * user mapper
     */
    @Resource
    private UserMapper userMapper;

    /**
     * 用户列表
     *
     * @return
     */
    @RequestMapping
    public List<User> userList() {
        logger.info("********TestController userList()" );
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
        logger.info("********save User" );
        user.setUserId(SnowflakeId.getId());
        // Snowflake分布式系统中，有一些需要使用全局唯一ID的场景，有些时候我们希望能使用一种简单一些的ID，并且希望ID能够按照时间有序生成。
        // Twitter的Snowflake 算法就是这种生成器。参数1为终端ID,参数2为数据中心ID
        user.setUserId(IdUtil.getSnowflake(1, 1).nextId());
        int insert = userMapper.insert(user);
        return user;
    }
}