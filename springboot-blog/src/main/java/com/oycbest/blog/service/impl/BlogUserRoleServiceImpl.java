package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogUserRoleDao;
import com.oycbest.blog.entity.BlogUserRole;
import com.oycbest.blog.service.BlogUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户与角色对应关系(BlogUserRole)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:17:13
 */
@Service("blogUserRoleService")
public class BlogUserRoleServiceImpl extends ServiceImpl<BlogUserRoleDao, BlogUserRole> implements BlogUserRoleService {

}