package com.oycbest.shirodemo.controller;

import com.oycbest.shirodemo.domain.User;
import com.oycbest.shirodemo.vo.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: oyc
 * @Date: 2020-06-02 16:39
 * @Description: 登录控制类
 */
@RestController
public class LoginController {

	@GetMapping("/login")
	public Result login(User user) {
		//添加用户认证信息
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getAccount(), user.getPassword());
		try {
			//进行验证，这里可以捕获异常，然后返回对应信息
			subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return Result.error("账号或密码错误！");
		} catch (AuthorizationException e) {
			e.printStackTrace();
			return Result.error("没有权限！");
		}
		return Result.ok("用户["+SecurityUtils.getSubject().getPrincipal()+"]登录成功");
	}

	/**
	 * 注解验角色和权限
	 */
	@RequiresRoles("admin")
	//@RequiresPermissions("add")
	@RequestMapping("/admin")
	public String index() {
		return "admin!";
	}

	/**
	 * 注解验角色和权限
	 */
	@RequiresRoles("user")
	//@RequiresPermissions("add")
	@RequestMapping("/user")
	public String user() {
		return "user!";
	}
}
