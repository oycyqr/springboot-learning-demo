package com.oycbest.ssmblog.config;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author: oyc
 * @Date: 2020-06-05 9:28
 * @Description: JwtToken
 */
public class JwtToken implements AuthenticationToken {

	private static final long serialVersionUID = 1L;
	private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
