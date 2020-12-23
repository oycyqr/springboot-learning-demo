package com.oyc.springbootsecurity.config;//package com.oyc.springbootsecurity.config;

import com.oyc.springbootsecurity.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        // 赋值数据源
        jdbcTokenRepository.setDataSource(dataSource);
        //启动时自动创建表,第一次执行会创建，以后要执行就要删除掉！
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //登录页面
                .loginPage("/login.html")
                //登录请求处理地址
                .loginProcessingUrl("/login")
                //登录成功默认跳转地址
                .defaultSuccessUrl("/success.html")
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
                .antMatchers("/user**").hasAnyRole("ADMIN", "USER")
                // 拥有 "admin" 权限即可访问
                //.antMatchers("/customer**").hasAuthority("admin")
                // 拥有 "admin","user","customer" 其中一个权限即可访问
                .antMatchers("/customer**").hasAnyAuthority("sys:user:edit", "sys:customer:edit")
                .and()
                //无权访问页面
                .exceptionHandling().accessDeniedPage("/accessDenied.html")
                //退出登录
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login.html").permitAll()
                //记住登录状态
                .and()
                .rememberMe()
                .tokenValiditySeconds(3600)
                .tokenRepository(persistentTokenRepository())
                .userDetailsService(userDetailsService)
                .rememberMeParameter("remember-me")
                .rememberMeCookieName("rememberMe")
                .and()
                .authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
    }
}