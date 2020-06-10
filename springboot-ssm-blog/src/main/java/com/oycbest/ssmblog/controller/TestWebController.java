package com.oycbest.ssmblog.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: oyc
 * @Date: 2020-06-03 9:39
 * @Description: JWT
 */
@RestController
public class TestWebController {

	/*private ISysUserService userService;

	@Autowired
	public void setService(ISysUserService userService) {
		this.userService = userService;
	}

	@PostMapping("/login")
	public ResponseBean login(@RequestParam("username") String username,
							  @RequestParam("password") String password) {
		SysUser user = userService.getUserByName(username);
		if(user==null) {
			return new ResponseBean(200, "用户不存在！", JwtUtil.sign(username, user.getPassword()));
		}
		String passwordEncode = PasswordUtil.encrypt(username, password, user.getSalt());
		if (passwordEncode.equals(user.getPassword())) {
			return new ResponseBean(200, "Login success", JwtUtil.sign(username, user.getPassword()));
		} else {
			throw new UnauthorizedException();
		}
	}

	@GetMapping("/article")
	public ResponseBean article() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			return new ResponseBean(200, "You are already logged in", null);
		} else {
			return new ResponseBean(200, "You are guest", null);
		}
	}

	@GetMapping("/require_auth")
	@RequiresAuthentication
	public ResponseBean requireAuth() {
		return new ResponseBean(200, "You are authenticated", null);
	}

	@GetMapping("/require_role")
	@RequiresRoles({"admin"})
	public ResponseBean requireRole() {
		return new ResponseBean(200, "You are visiting require_role", null);
	}

	@GetMapping("/require_permission")
	@RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
	public ResponseBean requirePermission() {
		return new ResponseBean(200, "You are visiting permission require edit,view", null);
	}

	@RequestMapping(path = "/401")
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseBean unauthorized() {
		return new ResponseBean(401, "Unauthorized", null);
	}*/
}
