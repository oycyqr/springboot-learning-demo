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
     * @return 用户列表
     */
    List<OyUser> getUserList();

    /**
     * 根据用户id获取用户详情信息
     * @param userId 用户id
     * @return 用户详情信息
     */
    OyUser getUserById(String userId);
}
