package com.oyc.security.handler;

import com.oyc.security.util.ResponseUtil;
import com.oyc.security.util.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: UnauthorizedEntryPoint
 * @Description: UnauthorizedEntryPoint
 * @Author oyc
 * @Date 2020/12/29 10:04
 * @Version 1.0
 */
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseUtil.out(response, Result.error("未授权统一处理"));
    }
}
