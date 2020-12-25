package com.oyc.sso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CustomUserDetailsService
 * @Description: 实现AuthenticationUserDetailsService，实现loadUserDetails方法
 * @Author oyc
 * @Date 2020/12/21 14:40
 * @Version 1.0
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("当前的用户名是：" + username);
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
        //封装用户信息，用于认证与密码校验
        return new User(username, passwordEncoder.encode(username), authorityList);

    }
}