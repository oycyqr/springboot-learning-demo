package com.oycbest.ssmblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.ssmblog.domain.BlogList;
import com.oycbest.ssmblog.domain.User;
import com.oycbest.ssmblog.service.UserRoleVoService;
import com.oycbest.ssmblog.service.UserService;
import com.oycbest.ssmblog.vo.UserRolerVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SsmUser)表控制层
 *
 * @author oyc
 * @since 2020-04-28 23:24:43
 */
@RestController
@RequestMapping("user")
public class UserController {
	/**
	 * 服务对象
	 */
	@Resource
	private UserService userService;
	/**
	 * 服务对象
	 */
	@Resource
	private UserRoleVoService userRoleVoService;

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("{id}")
	public User selectOne(@PathVariable("id") Integer id) {
		return userService.getById(id);
	}

	/**
	 * 列表数据
	 *
	 * @return 列表数据
	 */
	@GetMapping("list")
	public List<User> all() {
		return userService.list();
	}

	/**
	 * 列表数据
	 *
	 * @return 列表数据
	 */
	@GetMapping
	public ResponseEntity list(Page page, BlogList blogList) {
		QueryWrapper<BlogList> wrapper = new QueryWrapper<>();
		wrapper.setEntity(blogList);
		return ResponseEntity.ok().body(userService.page(page));
	}

	/**
	 * 修改数据
	 *
	 * @param user 实例对象
	 * @return 实例对象
	 */
	@PostMapping
	public Boolean save(User user) {
		return userService.save(user);
	}

	/**
	 * 新增或修改数据
	 *
	 * @param user 实例对象
	 * @return 实例对象
	 */
	@PutMapping
	public Boolean saveOrUpdate(User user) {
		return userService.saveOrUpdate(user);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Delete("{id}")
	public Boolean delete(@PathVariable("id") Integer id) {
		return userService.removeById(id);
	}

	/**
	 * 通过账号查询用户信息
	 *
	 * @param account 账号
	 * @return 对象列表
	 */
	@GetMapping("account/{account}")
	public UserRolerVo userRoleVo(@PathVariable("account") String account) {
		return userRoleVoService.queryByAccount(account);
	}
}
