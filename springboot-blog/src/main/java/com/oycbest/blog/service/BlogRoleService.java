package com.oycbest.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oycbest.blog.entity.BlogRole;

import java.util.List;

/**
 * 角色信息表(BlogRole)表服务接口
 *
 * @author oyc
 * @since 2020-12-16 11:17:04
 */
public interface BlogRoleService extends IService<BlogRole> {
    List<BlogRole> selectByUserId(String userId);

}