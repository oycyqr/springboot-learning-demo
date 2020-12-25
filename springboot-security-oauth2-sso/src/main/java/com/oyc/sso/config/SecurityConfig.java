package com.oyc.sso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: SecurityConfig
 * @Description: Security核心配置
 * @Author oyc
 * @Date 2020/12/25 9:55
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http/*.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()*/
                //请求权限配置
                .authorizeRequests()
                //不需要验证
                .antMatchers("/", "/index", "/hello").permitAll()
                .anyRequest()
                .authenticated()
                //配置http认证
                .and()
                .httpBasic()
                .and()
                //当用户进行重复登录时  强制销毁前一个登录用户  配置此应用必须添加Listener  HttpSessionEventPublisher
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/login?expired");

    }
}