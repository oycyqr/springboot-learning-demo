package com.oyc.security.handler;

import com.oyc.security.util.ResponseUtil;
import com.oyc.security.util.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: TokenLogoutHandler
 * @Description: TokenLogoutHandler
 * @Author oyc
 * @Date 2020/12/29 10:05
 * @Version 1.0
 */
public class TokenLogoutHandler implements LogoutHandler {
    private TokenManager tokenManager;

    public TokenLogoutHandler(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String token = request.getHeader("token");
        if (token != null) {
            //清空当前用户缓存中的权限数据
            tokenManager.removeToken(token);
            //String userName = tokenManager.getUserFromToken(token);
        }
        ResponseUtil.out(response, Result.ok("退出成功"));
    }
}
