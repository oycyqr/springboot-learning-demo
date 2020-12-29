package com.oyc.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: CommonController
 * @Description: CommonController
 * @Author oyc
 * @Date 2020/12/21 11:52
 * @Version 1.0
 */
@RestController
public class CommonController {

    @GetMapping(value = {"", "welcome"})
    public String welcome() {
        return "Welcome!!!";
    }

    @GetMapping("index")
    public String index() {
        return "index!!!";
    }

    @GetMapping("admin")
    public String admin() {
        return "admin!!!";
    }

    @GetMapping("user")
    public String user() {
        return "user!!!";
    }

    @GetMapping("customer")
    public String customer() {
        return "customer!!!";
    }
    /**
     * 方法执行前鉴权
     * @return
     */
    @GetMapping("roleAdmin")
    @Secured("ROLE_ADMIN")
    public String roleAdmin() {
        return "roleAdmin!!!";
    }

    /**
     * 方法执行前鉴权
     * @return
     */
    @GetMapping("preAuthorize")
    @PostAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String preAuthorize() {
        System.out.println("preAuthorize…………");
        return "preAuthorize!!!";
    }

    /**
     * 方法执行完再鉴权
     * @return
     */
    @GetMapping("postAuthorize")
    @PostAuthorize("hasAnyRole('ROLE_USER')")
    public String postAuthorize() {
        System.out.println("postAuthorize…………");
        return "PostAuthorize!!!";
    }
}
