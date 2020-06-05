package com.oycbest.shirodemo.config;

import com.oycbest.shirodemo.filter.ShiroLoginFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: oyc
 * @Date: 2020-06-02 16:11
 * @Description:
 */
@Configuration
public class ShiroConfig {
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/logout", "anon");
		filterChainDefinitionMap.put("/afterlogout", "anon");
		//过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了
		//authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/afterlogin", "anon");
		filterChainDefinitionMap.put("/**", "authc");
		//未登录，重定向到登录页面，前后端分离，不需要
		//shiroFilterFactoryBean.setLoginUrl("/login")
		//用户未登录不进行跳转，而是自定义返回json数据.获取filters
		Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
		//将自定义 的FormAuthenticationFilter注入shiroFilter中
		filters.put("authc", new ShiroLoginFilter());
		filterChainDefinitionMap.put("/**", "authc,user");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 将自己的验证方式加入容器
	 */
	@Bean
	public CustomRealm myShiroRealm() {
		CustomRealm customRealm = new CustomRealm();
		return customRealm;
	}

	/**
	 * 安全管理器
	 */
	@Bean
	public SecurityManager securityManager(CustomRealm myShiroRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置realm.
		securityManager.setRealm(myShiroRealm);
		// 记住我
		/*securityManager.setRememberMeManager(rememberMeManager());
		// 注入缓存管理器;
		securityManager.setCacheManager(getEhCacheManager());
		// session管理器
		securityManager.setSessionManager(sessionManager());*/
		return securityManager;
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
	 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
	 *
	 * @return
	 */
	@Bean
	@DependsOn({"lifecycleBeanPostProcessor"})
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager(myShiroRealm()));
		return authorizationAttributeSourceAdvisor;
	}
}
