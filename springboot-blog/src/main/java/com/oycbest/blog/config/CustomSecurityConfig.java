package com.oycbest.blog.config;

import com.oycbest.blog.controller.CustomUserDetailsService;
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
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许基于HttpServletRequest使用限制访问
        http.authorizeRequests()
                //不需要身份认证
                .antMatchers("/", "/home", "/index/**").permitAll()
                .antMatchers("/js/**", "/css/**", "/images/**", "/fronts/**", "/doc/**","/fonts/**").permitAll()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasAnyRole("admin","user")
                .antMatchers("/aa/**").hasAuthority("aa")
                .antMatchers("/customer/**").hasAnyAuthority("admin","user");

        http.formLogin()
                //登录页面
                .loginPage("/login.html")
                //登录请求处理地址
                .loginProcessingUrl("/login")
                //登录成功默认跳转地址
                .defaultSuccessUrl("/")
                //用户名
                .usernameParameter("username")
                //密码
                .passwordParameter("password")
                .permitAll()
                .and().authorizeRequests()
                    .antMatchers("/", "welcome").permitAll()
                    // 拥有ROLE_ADMIN角色即可访问
                    .antMatchers("/admin**").hasRole("ADMIN")
                    // 拥有 ROLE_ADMIN,ROLE_USER 中其中一个角色即可访问
                    .antMatchers("/user**").hasAnyRole("ADMIN","USER")
                    // 拥有 "admin" 权限即可访问
                    //.antMatchers("/customer**").hasAuthority("admin")
                    // 拥有 "admin","user","customer" 其中一个权限即可访问
                    .antMatchers("/customer**").hasAnyAuthority("sys:user:edit","sys:customer:edit")
                .and()
                //无权访问页面
                .exceptionHandling().accessDeniedPage("/accessDenied.html")
                .and()
                .authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
    }
}