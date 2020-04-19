package com.bestoyc.service;

import com.bestoyc.entity.OyUser;

import java.util.List;

/**
 * @author oyc
 * @Title:
 * @Description:用户服务接口类
 * @date 2018/7/1615:06
 */
public interface OyUserService {
    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    List<OyUser> getUserList();

    /**
     * 根据用户id获取用户详情信息
     *
     * @param userId 用户id
     * @return 用户详情信息
     */
    OyUser getUserById(Integer userId);


    /**
     * 新增用户
     *
     * @param user 用户信息
     */
    OyUser addUser(OyUser user);

    /**
     * 编辑用户信息
     *
     * @param user 用户信息
     */
    OyUser updateUser(OyUser user);

    /**
     * 根据用户id删除用户
     *
     * @param userId 用户id
     */
    void delUser(Integer userId);

}
