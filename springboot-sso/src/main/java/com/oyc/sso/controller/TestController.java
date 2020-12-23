package com.oyc.sso.controller;

import com.oyc.sso.util.CasUtil;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
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

    @Value(value = "${cas.server-url-prefix}")
    private String serverUrlPrefix = "";

    @Value(value = "${cas.client-host-url}")
    private String clientHostUrl = "";

    @GetMapping("user")
    @ResponseBody
    public String user(HttpServletRequest request) {
        Assertion assertion = (Assertion) request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
        String loginName = null;
        if (assertion != null) {
            AttributePrincipal principal = assertion.getPrincipal();
            loginName = principal.getName();
            System.out.println("访问者:" + loginName);
        }
        return "访问者:" + loginName;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:" + serverUrlPrefix + "/logout?service=" + clientHostUrl + "/sso-client/user";
    }
}
