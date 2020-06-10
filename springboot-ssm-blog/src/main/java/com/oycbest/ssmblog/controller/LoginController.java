package com.oycbest.ssmblog.controller;

import com.alibaba.fastjson.JSONObject;
import com.oycbest.ssmblog.constant.ShiroConstant;
import com.oycbest.ssmblog.domain.User;
import com.oycbest.ssmblog.service.UserRoleVoService;
import com.oycbest.ssmblog.util.JwtUtil;
import com.oycbest.ssmblog.vo.Result;
import com.oycbest.ssmblog.vo.UserRoleVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: oyc
 * @Date: 2020-06-02 16:39
 * @Description: 登录控制器
 */
@Slf4j
@RestController
public class LoginController {
	@Autowired
	private UserRoleVoService userRoleVoService;

	@RequestMapping("/login")
	public Result login(User user) {
		// 1. 校验用户是否有效
		UserRoleVo userRoleVo = userRoleVoService.queryByAccount(user.getAccount());
		if (userRoleVo == null) {
			return Result.build(200, "用户不存在！", JwtUtil.sign(user.getAccount(), user.getPassword()));
		}
		// 2. 校验用户名或密码是否正确
		String passwordEncode = userRoleVo.getPassword();// PasswordUtil.encrypt(userRoleVo.getAccount(), userRoleVo.getPassword(), userRoleVo.getSalt());
		if (!passwordEncode.equals(user.getPassword())) {
			//throw new UnauthorizedException();
			return Result.build(500, "用户名或密码错误", JwtUtil.sign(user.getPassword(), user.getPassword()));
		}
		return Result.build(200, "用户名: " + user.getAccount() + ",登录成功！", userInfo(userRoleVo));
	}
	/**
	 * 用户信息
	 *
	 * @param userRoleVo
	 * @return
	 */
	private JSONObject userInfo(UserRoleVo userRoleVo) {
		// 生成token
		String token = JwtUtil.sign(userRoleVo.getAccount(), userRoleVo.getPassword());
		// 设置token缓存有效时间
		//redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, token);
		//redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME*2 / 1000);

		JSONObject obj = new JSONObject();
		obj.put("token", token);
		obj.put("userRoleVo", userRoleVo);
		return obj;
	}

	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public Result logout(HttpServletRequest request, HttpServletResponse response) {
		//用户退出逻辑
		String token = request.getHeader(ShiroConstant.X_ACCESS_TOKEN);
		if(StringUtils.isEmpty(token)) {
			return Result.error("退出登录失败！");
		}
		String username = JwtUtil.getUsername(token);
		//LoginUser sysUser = sysBaseAPI.getUserByName(username);
		if(username!=null) {
			log.info(" 用户名:  "+username+",退出成功！ ");
			//清空用户登录Token缓存
			//redisUtil.del(CommonConstant.PREFIX_USER_TOKEN + token);
			//清空用户登录Shiro权限缓存
			//redisUtil.del(CommonConstant.PREFIX_USER_SHIRO_CACHE + sysUser.getId());
			//清空用户的缓存信息（包括部门信息），例如sys:cache:user::<username>
			//redisUtil.del(String.format("%s::%s", CacheConstant.SYS_USERS_CACHE, sysUser.getUsername()));
			//调用shiro的logout
			SecurityUtils.getSubject().logout();
			return Result.ok("退出登录成功！");
		}else {
			return Result.error("Token无效!");
		}
	}


	/**
	 * 注解验角色和权限
	 */
	@RequiresRoles("admin")
	@RequestMapping("/admin")
	public String index() {
		return "admin!";
	}

	/**
	 * 注解验角色和权限
	 */
	@RequiresRoles("user")
	@RequestMapping("/user")
	public String user() {
		return "user!";
	}
}
