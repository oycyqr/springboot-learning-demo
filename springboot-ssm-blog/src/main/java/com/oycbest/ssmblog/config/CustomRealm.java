package com.oycbest.ssmblog.config;

import com.oycbest.ssmblog.domain.Permission;
import com.oycbest.ssmblog.service.UserRoleVoService;
import com.oycbest.ssmblog.util.JwtUtil;
import com.oycbest.ssmblog.vo.RolePermissinVo;
import com.oycbest.ssmblog.vo.UserRoleVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: oyc
 * @Date: 2020-06-02 16:12
 * @Description: 自定义shiro认证器
 */
@Slf4j
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private UserRoleVoService userRoleVoService;

	/**
	 * 必须重写此方法，不然无法支持JWT
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof JwtToken;
	}

	/**
	 * 权限信息认证(包括角色以及权限)是用户访问controller的时候才进行验证(redis存储的此处权限信息)
	 * 触发检测用户权限时才会调用此方法，例如checkRole,checkPermission
	 *
	 * @param principals 身份信息
	 * @return AuthorizationInfo 权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("===============Shiro权限认证开始============ [ roles、permissions]==========");
		//获取登录用户名
		UserRoleVo userRoleVo = null;
		if (principals != null) {
			userRoleVo = (UserRoleVo) principals.getPrimaryPrincipal();
		}
		// 添加角色和权限
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for (RolePermissinVo role : userRoleVo.getRoles()) {
			//设置用户 角色集合
			simpleAuthorizationInfo.addRole(role.getRoleKey());
			//设置用户 权限集合
			for (Permission permission : role.getPerms()) {
				if (permission != null && permission.getPerms() != null && permission.getPerms() != "") {
					simpleAuthorizationInfo.addStringPermission(permission.getPerms());
				}
			}
		}
		log.info("===============Shiro权限认证成功==============");
		return simpleAuthorizationInfo;
	}

	/**
	 * 用户信息认证是在用户进行登录的时候进行验证(不存redis)
	 * 也就是说验证用户输入的账号和密码是否正确，错误抛出异常
	 *
	 * @param authenticationToken 用户登录的账号密码信息
	 * @return 返回封装了用户信息的 AuthenticationInfo 实例
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String token = (String) authenticationToken.getCredentials();
		if (token == null) {
			log.info("————————身份认证失败——————————");
			throw new AuthenticationException("token为空!");
		}
		// 校验token有效性
		UserRoleVo user = this.checkUserTokenIsEffect(token);
		return new SimpleAuthenticationInfo(user, token, getName());
	}

	/**
	 * 校验token的有效性
	 *
	 * @param token
	 */
	public UserRoleVo checkUserTokenIsEffect(String token) throws AuthenticationException {
		// 解密获得username，用于和数据库进行对比
		String username = JwtUtil.getUsername(token);
		if (username == null) {
			throw new AuthenticationException("token非法无效!");
		}

		// 查询用户信息
		log.info("———校验token是否有效————checkUserTokenIsEffect——————— " + token);
		UserRoleVo user = userRoleVoService.queryByAccount(username);
		if (user == null) {
			throw new AuthenticationException("用户不存在!");
		}
		// 判断用户状态
		if (user.getStatus() != 1) {
			throw new AuthenticationException("账号已被锁定,请联系管理员!");
		}
		// 校验token是否超时失效 & 或者账号密码是否错误
		if (!jwtTokenRefresh(token, username, user.getPassword())) {
			throw new AuthenticationException("Token失效，请重新登录!");
		}
		return user;
	}

	/**
	 * JWTToken刷新生命周期 （实现： 用户在线操作不掉线功能）
	 * 1、登录成功后将用户的JWT生成的Token作为k、v存储到cache缓存里面(这时候k、v值一样)，缓存有效期设置为Jwt有效时间的2倍
	 * 2、当该用户再次请求时，通过JWTFilter层层校验之后会进入到doGetAuthenticationInfo进行身份验证
	 * 3、当该用户这次请求jwt生成的token值已经超时，但该token对应cache中的k还是存在，则表示该用户一直在操作只是JWT的token失效了，程序会给token对应的k映射的v值重新生成JWTToken并覆盖v值，该缓存生命周期重新计算
	 * 4、当该用户这次请求jwt在生成的token值已经超时，并在cache中不存在对应的k，则表示该用户账户空闲超时，返回用户信息已失效，请重新登录。
	 * 注意： 前端请求Header中设置Authorization保持不变，校验有效性以缓存中的token为准。
	 * 用户过期时间 = Jwt有效时间 * 2。
	 *
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public boolean jwtTokenRefresh(String token, String userName, String passWord) {
		/*String cacheToken = String.valueOf(redisUtil.get(CommonConstant.PREFIX_USER_TOKEN + token));
		if (oConvertUtils.isNotEmpty(cacheToken)) {
			// 校验token有效性
			if (!JwtUtil.verify(cacheToken, userName, passWord)) {
				String newAuthorization = JwtUtil.sign(userName, passWord);
				// 设置超时时间
				redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, newAuthorization);
				redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME *2 / 1000);
				log.info("——————————用户在线操作，更新token保证不掉线—————————jwtTokenRefresh——————— "+ token);
			}
			return true;
		}
		return false;
		*/
		return true;
	}

	/**
	 * 清除当前用户的权限认证缓存
	 *
	 * @param principals 权限信息
	 */
	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

}
