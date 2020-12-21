package com.oyc.springbootsecurity.config;//package com.oyc.springbootsecurity.config;

import com.oyc.springbootsecurity.service.CustomUserDetailsService;
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
    private CustomPasswordEncoder customPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")//登录页面
                .loginProcessingUrl("/login") //登录请求处理地址
                .defaultSuccessUrl("/welcome")//登录成功默认跳转地址
                .usernameParameter("username")//用户名
                .passwordParameter("password")//密码
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/", "welcome").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();


    }
}