package com.oycbest.blog.config;


import com.oycbest.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @ClassName: WebSecurityConfig
 * @Description: WebSecurityConfig
 * @Author oyc
 * @Date 2020/12/16 17:37
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
        //允许基于HttpServletRequest使用限制访问
        http.authorizeRequests()
                //不需要身份认证
                .antMatchers("/", "/home", "/index/**").permitAll()
                .antMatchers("/js/**", "/css/**", "/images/**", "/fronts/**", "/doc/**").permitAll()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasAnyRole("admin,user")
                .antMatchers("/aa/**").hasAuthority("aa")
                .antMatchers("/customer/**").hasAnyAuthority("admin,user")

                //自定义登录界面
                .and().formLogin().loginPage("/login.html")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and().
                logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll()
                .and().
                authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable();
    }
}
