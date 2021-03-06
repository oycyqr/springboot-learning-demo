package com.oycbest.shirodemo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.shirodemo.mapper.UserRoleVoMapper;
import com.oycbest.shirodemo.service.UserRoleVoService;
import com.oycbest.shirodemo.vo.UserRolerVo;
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
