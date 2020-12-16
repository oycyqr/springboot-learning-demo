package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogMenuDao;
import com.oycbest.blog.entity.BlogMenu;
import com.oycbest.blog.service.BlogMenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单权限表(BlogMenu)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:17:02
 */
@Service("blogMenuService")
public class BlogMenuServiceImpl extends ServiceImpl<BlogMenuDao, BlogMenu> implements BlogMenuService {

}