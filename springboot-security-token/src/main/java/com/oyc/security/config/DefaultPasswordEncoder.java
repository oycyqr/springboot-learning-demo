package com.oyc.security.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DefaultPasswordEncoder
 * @Description: DefaultPasswordEncoder
 * @Author oyc
 * @Date 2020/12/29 9:59
 * @Version 1.0
 */
@Component
public class DefaultPasswordEncoder extends BCryptPasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        } else if (encodedPassword != null && encodedPassword.length() != 0) {
            return encodedPassword.equals(rawPassword);
        } else {
            System.out.println("Empty encoded password");
            return false;
        }
    }
}
