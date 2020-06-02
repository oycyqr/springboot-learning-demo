package com.oycbest.shirodemo.service;

import com.oycbest.shirodemo.domain.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author oyc
 * @since 2020-04-28 23:21:53
 */
public interface UserService {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	User queryById(Integer id);

	List<User> queryAll();

	/**
	 * 查询多条数据
	 *
	 * @param offset 查询起始位置
	 * @param limit  查询条数
	 * @return 对象列表
	 */
	List<User> queryAllByLimit(int offset, int limit);

	/**
	 * 新增数据
	 *
	 * @param ssmUser 实例对象
	 * @return 实例对象
	 */
	User insert(User ssmUser);

	/**
	 * 修改数据
	 *
	 * @param ssmUser 实例对象
	 * @return 实例对象
	 */
	User update(User ssmUser);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Integer id);

	/**
	 * 根据用户登录名称获取用户信息
	 *
	 * @param account 用户名称
	 * @return
	 */
	User queryByAccount(String account);

}
