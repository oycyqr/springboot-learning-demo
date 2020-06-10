package com.oycbest.ssmblog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.mapper.UserRoleVoMapper;
import com.oycbest.ssmblog.service.UserRoleVoService;
import com.oycbest.ssmblog.vo.UserRoleVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SsmUser)表服务实现类
 *
 * @author oyc
 * @since 2020-04-28 23:21:54
 */
@Service("userRoleService")
public class UserRoleVoServiceImpl extends ServiceImpl<UserRoleVoMapper, UserRoleVo> implements UserRoleVoService {
	@Resource
	private UserRoleVoMapper userRoleVoMapper;

	/**
	 * 通过用户登录名称获取用户信息
	 *
	 * @param account 用户登录名称
	 * @return 实例对象
	 */
	@Override
	public UserRoleVo queryByAccount(String account) {
		return userRoleVoMapper.queryByAccount(account);
	}

}
