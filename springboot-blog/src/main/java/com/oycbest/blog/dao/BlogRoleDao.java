package com.oycbest.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.blog.entity.BlogRole;

import java.util.List;

/**
 * 角色信息表(BlogRole)表数据库访问层
 *
 * @author oyc
 * @since 2020-12-16 11:17:04
 */
public interface BlogRoleDao extends BaseMapper<BlogRole> {
    /**
     * 根据用户id获取角色列表
     * @param userId 用户id
     * @return
     */
    List<BlogRole> selectByUserId(String userId);
}