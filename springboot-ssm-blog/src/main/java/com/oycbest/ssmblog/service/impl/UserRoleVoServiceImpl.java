package com.oycbest.ssmblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.domain.User;
import com.oycbest.ssmblog.mapper.UserMapper;
import com.oycbest.ssmblog.mapper.UserRoleVoMapper;
import com.oycbest.ssmblog.service.UserRoleVoService;
import com.oycbest.ssmblog.service.UserService;
import com.oycbest.ssmblog.vo.UserRolerVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SsmUser)表服务实现类
 *
 * @author oyc
 * @since 2020-04-28 23:21:54
 */
@Service("userRoleService")
public class UserRoleVoServiceImpl extends ServiceImpl<UserRoleVoMapper, UserRolerVo> implements UserRoleVoService {
    @Resource
    private UserRoleVoMapper userRoleVoMapper;

    /**
     * 通过用户登录名称获取用户信息
     *
     * @param account 用户登录名称
     * @return 实例对象
     */
    @Override
    public UserRolerVo queryByAccount(String account) {
        return userRoleVoMapper.queryByAccount(account);
    }

}
