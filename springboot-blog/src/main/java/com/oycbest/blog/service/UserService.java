package com.oycbest.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oycbest.blog.entity.BlogUser;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/12/21 10:56 下午
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private BlogUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authority = AuthorityUtils.createAuthorityList("admin");
        //用户权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            QueryWrapper<BlogUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",username);
        BlogUser user = userService.getOne(queryWrapper);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return new User(username, user.getPassword(), authority);
    }
}
