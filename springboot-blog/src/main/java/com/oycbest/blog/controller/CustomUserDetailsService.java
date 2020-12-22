package com.oycbest.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oycbest.blog.dao.BlogUserDao;
import com.oycbest.blog.entity.BlogRole;
import com.oycbest.blog.entity.BlogUser;
import com.oycbest.blog.service.BlogRoleService;
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
    private BlogUserDao blogUserDao;

    @Autowired
    private BlogRoleService blogRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库获取用户信息
        QueryWrapper<BlogUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",username);
        BlogUser blogUser = blogUserDao.selectOne(queryWrapper);
        //用户不存在，直接抛出异常
        if (blogUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //从数据库获取用户对应角色或者权限标识
        //user --> user_role --> role
        //user --> user_permission --> permission
        List<BlogRole> roles = blogRoleService.selectByUserId(blogUser.getId());

//        Set<Role> roleSet = user.getRoles();
//        Set<Permission> permissionSet = user.getPermissions();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        //权限
//        permissionSet.stream().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getPerms())));
//        //角色
        roles.stream().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getRoleKey())));
        //封装用户信息，用于认证与密码校验
        return new User(blogUser.getAccount(), blogUser.getPassword(), authorities);
    }
}