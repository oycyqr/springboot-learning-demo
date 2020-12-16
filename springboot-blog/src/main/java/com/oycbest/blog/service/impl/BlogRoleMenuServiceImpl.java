package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogRoleMenuDao;
import com.oycbest.blog.entity.BlogRoleMenu;
import com.oycbest.blog.service.BlogRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * 角色与菜单对应关系(BlogRoleMenu)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:17:06
 */
@Service("blogRoleMenuService")
public class BlogRoleMenuServiceImpl extends ServiceImpl<BlogRoleMenuDao, BlogRoleMenu> implements BlogRoleMenuService {

}