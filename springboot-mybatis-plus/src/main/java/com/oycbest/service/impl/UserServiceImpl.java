package com.oycbest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.domain.User;
import com.oycbest.mapper.UserMapper;
import com.oycbest.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (SsmUser)表服务实现类
 *
 * @author oyc
 * @since 2020-04-28 23:21:54
 */
@Service("ssmUserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
