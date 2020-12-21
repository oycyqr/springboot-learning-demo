package com.oycbest.blog.config;

import com.oycbest.blog.util.Md5Util;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/12/21 11:09 下午
 */
@Component
public class PasswordEncoder extends BCryptPasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return Md5Util.hash(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return Md5Util.matches(rawPassword, encodedPassword);
    }
}
