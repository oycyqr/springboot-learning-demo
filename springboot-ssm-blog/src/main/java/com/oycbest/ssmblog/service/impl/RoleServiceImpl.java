package com.oycbest.ssmblog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.domain.Role;
import com.oycbest.ssmblog.mapper.RoleMapper;
import com.oycbest.ssmblog.service.RoleService;
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
