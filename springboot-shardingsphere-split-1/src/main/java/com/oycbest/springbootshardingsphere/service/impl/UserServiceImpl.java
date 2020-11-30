package com.oycbest.springbootshardingsphere.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.springbootshardingsphere.domain.User;
import com.oycbest.springbootshardingsphere.mapper.UserMapper;
import com.oycbest.springbootshardingsphere.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List getUserAddressList() {
        return userMapper.getUserAddressList();
    }
}
