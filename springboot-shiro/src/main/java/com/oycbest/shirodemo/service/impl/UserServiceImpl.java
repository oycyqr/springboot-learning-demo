package com.oycbest.shirodemo.service.impl;

import com.oycbest.shirodemo.domain.User;
import com.oycbest.shirodemo.mapper.UserMapper;
import com.oycbest.shirodemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author oyc
 * @since 2020-04-28 23:21:54
 */
@Service("ssmUserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return userMapper.queryById(id);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll(new User());
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return userMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User ssmUser) {
        userMapper.insert(ssmUser);
        return ssmUser;
    }

    /**
     * 修改数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User ssmUser) {
        userMapper.update(ssmUser);
        return this.queryById(ssmUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public User queryByAccount(String account) {
        return userMapper.queryByAccount(account);
    }
}
