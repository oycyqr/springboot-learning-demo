package com.oyc.sso.config;

import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: OAuth2Configuration
 * @Description: OAuth2Configuration
 * @Author oyc
 * @Date 2020/12/25 9:53
 * @Version 1.0
 */
@Configuration
public class OAuth2Config {
    public static final String ROLE_ADMIN = "ADMIN";
    //访问客户端密钥
    public static final String CLIENT_SECRET = "test";
    //访问客户端ID
    public static final String CLIENT_ID = "test";
    //鉴权模式
    public static final String GRANT_TYPE[] = {"password", "refresh_token"};

    public static final String serverUrl = "http://146.56.192.87:8080/cas/";
}