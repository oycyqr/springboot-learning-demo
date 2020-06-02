package com.oycbest.shirodemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: oyc
 * @Date: 2020-06-02 16:41
 * @Description: 权限异常处理
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

	@ExceptionHandler
	@ResponseBody
	public String ErrorHandler(AuthorizationException e) {
		log.error("没有通过权限验证！", e);
		return "没有通过权限验证！";
	}

	@ExceptionHandler
	@ResponseBody
	public String ErrorHandler(Exception e) {
		log.error("系统发生异常！", e);
		return "系统发生异常！";
	}
}
