package com.oyc.security.config;

import com.oyc.security.filter.TokenAuthenticationFilter;
import com.oyc.security.filter.TokenLoginFilter;
import com.oyc.security.handler.TokenLogoutHandler;
import com.oyc.security.handler.TokenManager;
import com.oyc.security.handler.UnauthorizedEntryPoint;
import com.oyc.security.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName: TokenWebSecurityConfig
 * @Description: TokenWebSecurityConfig
 * @Author oyc
 * @Date 2020/12/29 9:55
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 密码管理工具类
     */
    @Autowired
    private DefaultPasswordEncoder defaultPasswordEncoder;

    /**
     * 密码管理工具类
     */
    @Autowired
    private TokenManager tokenManager;

    /**
     * 用户服务类
     */
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 配置设置，设置退出的地址和token
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                //未授权处理
                .authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().logout().logoutUrl("/logout")
                .addLogoutHandler(new TokenLogoutHandler(tokenManager)).and()
                .addFilter(new TokenLoginFilter(authenticationManager(), tokenManager))
                .addFilter(new TokenAuthenticationFilter(authenticationManager(), tokenManager)).httpBasic();
    }

    /**
     * 密码处理
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(defaultPasswordEncoder);
    }

    /**
     * 配置哪些请求不拦截
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/**", "/swagger-ui.html/**");
    }
}
