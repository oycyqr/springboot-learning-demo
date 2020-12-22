package com.oycbest.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oycbest.blog.entity.BlogRole;
import com.oycbest.blog.entity.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 用户服务类、登录相关
 * @Author oyc
 * @Date 2020/12/21 10:56 下午
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private BlogUserService userService;

    @Autowired
    private BlogRoleService blogRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从用户信息表获取用户
        QueryWrapper<BlogUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", username);
        BlogUser user = userService.getOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        //角色
        List<BlogRole> blogRoles = blogRoleService.selectByUserId(user.getId());
        blogRoles.stream().forEach(b -> {
            if (StringUtils.hasText(b.getRoleKey())) {
                authorities.add(new SimpleGrantedAuthority(b.getRoleKey()));
            }
        });
        return new User(username, user.getPassword(), authorities);
    }
}
