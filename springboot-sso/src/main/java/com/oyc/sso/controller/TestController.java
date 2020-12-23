package com.oyc.sso.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: TestController
 * @Description: TestController
 * @Author oyc
 * @Date 2020/12/23 17:32
 * @Version 1.0
 */
@Controller
public class TestController {

    @Value(value = "${sso.logout-url}")
    private String logoutUrl = "";

    @Value(value = "${cas.client-host-url}")
    private String clientHostUrl = "";

    @GetMapping("user")
    @ResponseBody
    public String user(HttpServletRequest request) {
        String loginName = CASUtil.getAccountNameFromCas(request);
        if (StringUtils.hasLength(loginName)) {
            System.out.println("访问者:" + loginName);
            request.getSession().setAttribute("loginName", loginName);
        }
        return "访问者:" + loginName;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:" + logoutUrl + "?service=" + clientHostUrl+"/sso-client";
    }
}