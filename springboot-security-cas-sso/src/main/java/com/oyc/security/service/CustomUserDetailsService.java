package com.oyc.security.service;

import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class CustomUserDetailsService implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {

    @Override
    public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) throws UsernameNotFoundException {
        System.out.println("当前的用户名是：" + token.getName());
        //TODO 根据当前用户名获取相应权限
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
        //封装用户信息，用于认证与密码校验
        return new User(token.getName(), token.getName(), authorityList);
    }
}
