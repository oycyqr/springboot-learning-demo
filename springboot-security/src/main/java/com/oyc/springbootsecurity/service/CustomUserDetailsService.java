package com.oyc.springbootsecurity.service;

import com.oyc.springbootsecurity.repostiry.UserRepostiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CustomUserDetailsService
 * @Description: CustomUserDetailsService
 * @Author oyc
 * @Date 2020/12/21 14:40
 * @Version 1.0
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepostiry userRepostiry;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库获取用户信息
        com.oyc.springbootsecurity.entity.User user = userRepostiry.findByAccount(username);
        //用户不存在，直接抛出异常
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //从数据库获取用户对应角色或者权限标识（TODO）
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("admin","user");
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        //封装用户信息，用于认证与密码校验
        return new User(user.getAccount(),user.getPassword(), authorities);
    }
}