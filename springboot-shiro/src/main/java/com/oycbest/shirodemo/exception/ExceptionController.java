package com.oycbest.shirodemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: oyc
 * @Date: 2020-06-02 16:41
 * @Description: 权限异常处理
 */
@RestControllerAdvice
@Slf4j
public class ExceptionController {

	@ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity ErrorHandler401(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
		return new ResponseEntity("没有通过权限验证!", HttpStatus.FORBIDDEN);
    }

    /**
     * shiro的异常
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResponseEntity handleShiroException(ShiroException e) {
		log.error("系统发生异常！", e);
        return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

	/**
	 * 	捕捉其他所有异常
 	 */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity globalException(HttpServletRequest request, Throwable e) {
		log.error("系统发生异常！", e);
        return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(getStatus(request).value()));
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}

