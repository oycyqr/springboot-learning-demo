package com.oycbest.springbootexception.controller;

import com.oycbest.springbootexception.exception.ServiceException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/4/26 10:02 下午
 */
@RestController
@RequestMapping("except")
public class ExceptionController {

    @GetMapping("/page1")
    public Map page1(HttpServletRequest request){
        String param1 = request.getParameter("p1");
        if(StringUtils.isEmpty(param1)){
            throw new ServiceException("参数不能为空");
        }
        if("p1".equals(param1)){
            throw new ServiceException("参数有误");
        }
        return null;
    }
}
