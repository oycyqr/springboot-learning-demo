package com.oycbest.shirodemo.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 404 异常处理
 * @Author oyc
 * @Date 2020/6/6 12:14 上午
 */
@RestController
public class NotFoundException implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(ERROR_PATH)
    public ResponseEntity error(){
        return ResponseEntity.badRequest().body("接口不存在！");
    }
}
