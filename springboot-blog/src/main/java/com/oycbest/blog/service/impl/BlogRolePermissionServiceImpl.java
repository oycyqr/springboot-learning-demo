package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogRolePermission;
import com.oycbest.blog.mapper.BlogRolePermissionMapper;
import com.oycbest.blog.service.BlogRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BlogRolePermission)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@Service("blogRolePermissionService")
public class BlogRolePermissionServiceImpl extends ServiceImpl<BlogRolePermissionMapper,BlogRolePermission> implements BlogRolePermissionService {
}
