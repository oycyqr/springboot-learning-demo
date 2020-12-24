package com.oyc.security.controller;

import com.oyc.security.config.CasProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description: TestController
 * @Author oyc
 * @Date 2020/12/23 19:32
 * @Version 1.0
 */
@RestController
@RequestMapping
public class TestController {

    @Autowired
    private CasProperties casProperties;

    @GetMapping({"", "/", "index"})
    public String index() {
        return "首页";
    }

    @GetMapping("hello")
    public String hello() {
        return "hello 不验证";
    }

    @PreAuthorize("hasRole('SALER')")
    @GetMapping("saler")
    public String saler() {
        return "saler 有权限访问";
    }

    /**
     * 必须要有ADMIN 角色才能访问
     *
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("admin")
    public String security() {
        return "admin 有权限访问";
    }

    @GetMapping("user")
    public String user() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (principal instanceof User) {
            user = (User) principal;
        }
        System.out.println(user.getUsername());
        return "访问者:" + principal;
    }

    @GetMapping("logout")
    public String logout() {
        return "redirect:" + casProperties.getCasServerLogoutUrl();
    }
}
