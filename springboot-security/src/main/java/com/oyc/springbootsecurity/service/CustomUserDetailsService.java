package com.oyc.springbootsecurity.service;

import com.oyc.springbootsecurity.entity.Permission;
import com.oyc.springbootsecurity.entity.Role;
import com.oyc.springbootsecurity.repostiry.UserRepostiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        //从数据库获取用户对应角色或者权限标识
        //user --> user_role --> role
        //user --> user_permission --> permission
        Set<Role> roleSet = user.getRoles();
        Set<Permission> permissionSet = user.getPermissions();
        List<GrantedAuthority> authorities = new ArrayList<>();
        //权限
        permissionSet.stream().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getPerms())));
        //角色
        roleSet.stream().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getRoleKey())));
        //封装用户信息，用于认证与密码校验
        return new User(user.getAccount(), user.getPassword(), authorities);
    }
}