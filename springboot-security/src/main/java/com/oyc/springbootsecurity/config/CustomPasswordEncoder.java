package com.oyc.springbootsecurity.config;//package com.oyc.springbootsecurity.config;

import com.oyc.springbootsecurity.util.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CustomPasswordEncoder
 * @Description: 加密器
 * @Author oyc
 * @Date 2020/12/21 14:06
 * @Version 1.0
 */
@Component
public class CustomPasswordEncoder extends BCryptPasswordEncoder {
     private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String encode(CharSequence rawPassword) {
        return Md5Util.hash(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        } else if (encodedPassword != null && encodedPassword.length() != 0) {
            return Md5Util.hash(rawPassword.toString()).equals(encodedPassword);
        } else {
            this.logger.warn("Empty encoded password");
            return false;
        }
    }
}