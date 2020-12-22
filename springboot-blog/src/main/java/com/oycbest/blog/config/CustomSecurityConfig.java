package com.oycbest.blog.config;

import com.oycbest.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName: CustomSecurityConfig
 * @Description: CustomSecurityConfig
 * @Author oyc
 * @Date 2020/12/21 14:06
 * @Version 1.0
 */
@Configuration
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //登录页面
                .loginPage("/login.html")
                //登录请求处理地址
                .loginProcessingUrl("/login")
                //登录成功默认跳转地址
                .defaultSuccessUrl("/welcome")
                //用户名
                .usernameParameter("username")
                //密码
                .passwordParameter("password")
                .permitAll()
                .and()
                //无权访问页面
                .exceptionHandling().accessDeniedPage("/accessDenied.html");

        //允许基于HttpServletRequest使用限制访问
        http.authorizeRequests()
                //不需要身份认证
                .antMatchers("/", "/home", "/index/**", "/welcome").permitAll()
                .antMatchers("/js/**", "/css/**", "/images/**", "/fronts/**", "/doc/**", "/fonts/**").permitAll()
                // 拥有ROLE_ADMIN角色即可访问
                .antMatchers("/admin**").hasRole("ADMIN")
                // 拥有 ROLE_ADMIN,ROLE_USER 中其中一个角色即可访问
                .antMatchers("/user**").hasAnyRole("ADMIN", "USER")
                // 拥有 "admin" 权限即可访问
                //.antMatchers("/customer**").hasAuthority("admin")
                // 拥有 "admin","user","customer" 其中一个权限即可访问
                //.antMatchers("/customer**").hasAnyAuthority("sys:user:edit", "sys:customer:edit")
                .anyRequest().authenticated();


        http.csrf().disable();
    }
}
