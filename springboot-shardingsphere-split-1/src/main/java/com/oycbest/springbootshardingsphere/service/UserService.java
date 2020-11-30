package com.oycbest.springbootshardingsphere.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oycbest.springbootshardingsphere.domain.User;

import java.util.List;

/**
 * @author oyc
 * @since2020-10-28 23:21:52
 */
public interface UserService extends IService<User> {
    List getUserAddressList();
}
