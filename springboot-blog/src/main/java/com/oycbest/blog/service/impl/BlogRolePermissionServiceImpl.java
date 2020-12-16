package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogRolePermissionDao;
import com.oycbest.blog.entity.BlogRolePermission;
import com.oycbest.blog.service.BlogRolePermissionService;
import org.springframework.stereotype.Service;

/**
 * (BlogRolePermission)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:17:08
 */
@Service("blogRolePermissionService")
public class BlogRolePermissionServiceImpl extends ServiceImpl<BlogRolePermissionDao, BlogRolePermission> implements BlogRolePermissionService {

}