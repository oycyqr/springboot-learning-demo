package com.oycbest.shirodemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.shirodemo.domain.User;
import com.oycbest.shirodemo.mapper.UserMapper;
import com.oycbest.shirodemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (SsmUser)表服务实现类
 *
 * @author oyc
 * @since 2020-04-28 23:21:54
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
