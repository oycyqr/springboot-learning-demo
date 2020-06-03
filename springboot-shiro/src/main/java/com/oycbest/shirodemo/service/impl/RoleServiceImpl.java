package com.oycbest.shirodemo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.shirodemo.domain.Role;
import com.oycbest.shirodemo.mapper.RoleMapper;
import com.oycbest.shirodemo.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author oyc
 * @since 2020-06-02 22:00:50
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
