package com.oyc.springbootsecurity.config;

/**
 * @ClassName: SecurityConfig
 * @Description: SecurityConfig
 * @Author oyc
 * @Date 2020/12/21 14:06
 * @Version 1.0
 */
/*
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置用户名密码：zhangsan、123456，由于security强制要使用密码加密，这里使用推荐的BCryptPasswordEncoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123456");
        auth.inMemoryAuthentication().withUser("zhangsan").password(password).roles("admin");
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}*/
