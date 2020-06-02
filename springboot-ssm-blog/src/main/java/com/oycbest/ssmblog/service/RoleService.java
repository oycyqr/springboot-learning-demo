package com.oycbest.ssmblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.domain.Blog;
import com.oycbest.ssmblog.domain.Role;
import com.oycbest.ssmblog.mapper.BlogMapper;
import com.oycbest.ssmblog.mapper.RoleMapper;

import java.util.List;

/**
 * 角色信息表(Role)表服务接口
 *
 * @author oyc
 * @since 2020-06-02 22:00:50
 */
public interface RoleService extends IService<Role> {
}
