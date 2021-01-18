package com.oyc.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 集中式认证流程
 * 用户认证： 使用UsernamePasswordAuthenticationFilter过滤器中attemptAuthentication方法实现认证功能，
 * 该过滤器父类中successfulAuthentication方法实现认证成功后的操作。
 * 身份校验： 使用BasicAuthenticationFilter过滤器中doFilterInternal方法验证是否登录，以决定能否进入后续过滤器。
 *
 * 分布式认证流程
 * 用户认证：由于分布式项目，多数是前后端分离的架构设计，我们要满足可以接受异步post的认证请求参数，需要修改UsernamePasswordAuthenticationFilter过滤器中attemptAuthentication方法，
 * 让其能够接收请求体。另外，默认successfulAuthentication方法在认证通过后，是把用户信息直接放入session就完事了，现在我们需要修改这个方法，在认证通过后生成token并返回给用户。
 * 身份校验： 原来BasicAuthenticationFilter过滤器中doFilterInternal方法校验用户是否登录，就是看session中是否有用户信息，我们要修改为，验证用户携带的token是否合法，
 * 并解析出用户信息，交给SpringSecurity，以便于后续的授权功能可以正常使用。
 */
@SpringBootApplication
public class SecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtApplication.class, args);
    }

}
