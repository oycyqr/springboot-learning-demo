一、背景：
在 B/S 系统中，登录功基本都是依靠 Cookie 来实现的，用户登录成功之后主要需要客户端和服务端完成以下两项工作：

（1）服务端将登录状态记录到 Session 中，或者签发Token；

（2）客户端利用Cookie保存于服务端对应的 Session ID 或 Token。之后每次请求都会带上Cookie信息(包含Session ID或者Token），当服务端收到请求后，通过验证 Cookie 中的信息来判断用户是否登录 。

单点登录： 单点登录（Single Sign On, SSO）是指在同一帐号平台下的多个应用系统中，用户只需登录一次，即可访问所有相互信任的应用系统。单点登录的本质就是在多个应用系统中共享登录状态。 SSO是目前比较流行的企业业务整合的解决方案之一。

如果用户的登录状态是记录在 Session 中的，要实现共享登录状态，就要先共享 Session，比如可以将 Session 序列化到 Redis 中，让多个应用系统共享同一个 Redis，直接读取 Redis 来获取 Session。当然仅此是不够的，因为不同的应用系统有着不同的域名，尽管 Session 共享了，但是由于 Session ID 是往往保存在浏览器 Cookie 中的，因此存在作用域的限制，无法跨域名传递，也就是说当用户在 app1.com 中登录后，Session ID 仅在浏览器访问 app1.com 时才会自动在请求头中携带，而当浏览器访问 app2.com 时，Session ID 是不会被带过去的。实现单点登录的关键在于，如何让 Session ID（或 Token）在多个域中共享。

目前而言，主要有以下3种方式：

（1）父域 Cookie：例如：baike.baidu.com、wenku.baidu.com、zhida.baidu.com可以将认证的cookie放入baidu.com这个父级域名中，从而实现登录信息的共享。此种实现方式比较简单，但不支持跨主域名。

（2）认证中心：我们可以部署一个认证中心，认证中心就是一个专门负责处理登录请求的独立的 Web 服务。用户统一在认证中心进行登录，登录成功后，认证中心记录用户的登录状态，并将 Token 写入 Cookie。（注意这个 Cookie 是认证中心的，应用系统是访问不到的。）

应用系统检查当前请求有没有 Token，如果没有，说明用户在当前系统中尚未登录，那么就将页面跳转至认证中心。由于这个操作会将认证中心的 Cookie 自动带过去，因此，认证中心能够根据 Cookie 知道用户是否已经登录过了。如果认证中心发现用户尚未登录，则返回登录页面，等待用户登录，如果发现用户已经登录过了，就不会让用户再次登录了，而是会跳转回目标 URL ，并在跳转前生成一个 Token，拼接在目标 URL 的后面，回传给目标应用系统。

应用系统拿到 Token 之后，还需要向认证中心确认下 Token 的合法性，防止用户伪造。确认无误后，应用系统记录用户的登录状态，并将 Token 写入 Cookie，然后给本次访问放行。（注意这个 Cookie 是当前应用系统的，其他应用系统是访问不到的。）当用户再次访问当前应用系统时，就会自动带上这个 Token，应用系统验证 Token 发现用户已登录，于是就不会有认证中心什么事了。

目前被广泛使用的方案主要是Apereo CAS 。Apereo CAS 是一个企业级单点登录系统，其中 CAS 的意思是”Central Authentication Service“。它最初是耶鲁大学实验室的项目，后来转让给了 JASIG 组织，项目更名为 JASIG CAS，后来该组织并入了 Apereo 基金会，项目也随之更名为 Apereo CAS。

（3）LocalStorage 跨域：在前后端分离的情况下，完全可以不使用 Cookie，我们可以选择将 Session ID （或 Token ）保存到浏览器的 LocalStorage 中，让前端在每次向后端发送请求时，主动将 LocalStorage 的数据传递给服务端。这些都是由前端来控制的，后端需要做的仅仅是在用户登录成功后，将 Session ID （或 Token ）放在响应体中传递给前端。在这样的场景下，单点登录完全可以在前端实现。前端拿到 Session ID （或 Token ）后，除了将它写入自己的 LocalStorage 中之外，还可以通过特殊手段将它写入多个其他域下的 LocalStorage 中。

二、JWT介绍


JWT概念说明
从分布式认证流程中，我们不难发现，这中间起最关键作用的就是token，token的安全与否，直接关系到系统的健壮性，这里我们选择使用JWT来实现token的生成和校验。JWT，全称JSON Web Token，官网地址https://jwt.io，是一款出色的分布式身份校验方案。可以生成token，也可以解析检验token。

JWT生成的token由三部分组成：
该对象为一个很长的字符串，字符之间通过"."分隔符分为三个子串。 每一个子串表示了一个功能块，总共有以下三个部分：JWT 头、有效载荷和签名。

头部：JWT 头部分是一个描述 JWT 元数据的 JSON 对象，主要设置一些规范信息，签名部分的编码格式就在头部中声明。

载荷：token中存放有效信息的部分，是 JWT 的主体内容部分，是一个 JSON 对象，包含需要传递的数据。比如用户名，用户角色，过期时间等，但是不要放密码，会泄露！

指定七个默认字段供选择。
iss：发行人
exp：到期时间
sub：主题
aud：用户
nbf：在此之前不可用
iat：发布时间
jti：JWT ID 用于标识该 JWT
除以上默认字段外，我们还可以自定义私有字段，如下例：
{
"sub": "11111",
"name": "Atom",
"admin": true
}
签名：将头部与载荷分别采用base64编码后，用“.”相连，再加入盐，最后使用头部声明的编码类型进行编码，就得到了签名。通过指定的算法生成哈希，以确保数据不会被篡改。 首先，需要指定一个密码（secret）。该密码仅仅为保存在服务器中，并且不能向用户公 开。然后，使用标头中指定的签名算法（默认情况下为 HMAC SHA256）根据以下公式生成签名。 HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(claims), secret) 在计算出签名哈希后，JWT 头，有效载荷和签名哈希的三个部分组合成一个字符串，每个部分用"."分隔，就构成整个 JWT 对象。

JWT生成token的安全性分析
从JWT生成的token组成上来看，要想避免token被伪造，主要就得看签名部分了，而签名部分又有三部分组成，其中头部和载荷的base64编码，几乎是透明的，毫无安全性可言，那么最终守护token安全的重担就落在了加入的盐上面了！试想：如果生成token所用的盐与解析token时加入的盐是一样的。岂不是类似于中国人民银行把人民币防伪技术公开了？大家可以用这个盐来解析token，就能用来伪造token。这时，我们就需要对盐采用非对称加密的方式进行加密，以达到生成token与校验token方所用的盐不一致的安全效果！

非对称加密RSA介绍
基本原理：同时生成两把密钥：私钥和公钥，私钥隐秘保存，公钥可以下发给信任客户端私钥加密，持有私钥或公钥才可以解密公钥加密，持有私钥才可解密 优点：安全，难以破解 缺点：算法比较耗时，为了安全，可以接受 历史：三位数学家Rivest、Shamir 和 Adleman 设计了一种算法，可以实现非对称加密。这种算法用他们三个人的名字缩写：RSA。

三、具体代码实现
集中式认证流程：

用户认证： 使用UsernamePasswordAuthenticationFilter过滤器中attemptAuthentication方法实现认证功能，该过滤器父类中successfulAuthentication方法实现认证成功后的操作。
身份校验： 使用BasicAuthenticationFilter过滤器中doFilterInternal方法验证是否登录，以决定能否进入后续过滤器。

分布式认证流程：

用户认证：由于分布式项目，多数是前后端分离的架构设计，我们要满足可以接受异步post的认证请求参数，需要修改UsernamePasswordAuthenticationFilter过滤器中attemptAuthentication方法，让其能够接收请求体。另外，默认successfulAuthentication方法在认证通过后，是把用户信息直接放入session就完事了，现在我们需要修改这个方法，在认证通过后生成token并返回给用户。
身份校验： 原来BasicAuthenticationFilter过滤器中doFilterInternal方法校验用户是否登录，就是看session中是否有用户信息，我们要修改为，验证用户携带的token是否合法，并解析出用户信息，交给SpringSecurity，以便于后续的授权功能可以正常使用。
3.1引入依赖
<!--spring security 安全框架-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<!--JWT工具依赖-->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.0</version>
</dependency>
3.2编写核心配置类
Spring Security 的核心配置就是继承 WebSecurityConfigurerAdapter 并注解@EnableWebSecurity 的配置。这个配置指明了用户名密码的处理方式、请求路径、登录、登出控制等和安全相关的配置。

package com.oyc.security.config;
 
import com.oyc.security.filter.TokenAuthenticationFilter;
import com.oyc.security.filter.TokenLoginFilter;
import com.oyc.security.handler.UnauthorizedEntryPoint;
import com.oyc.security.util.DefaultPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
 
/**
 * @ClassName: TokenWebSecurityConfig
 * @Description: TokenWebSecurityConfig
 * @Author oyc
 * @Date 2021/1/18 10:57
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 密码管理工具类
     */
    @Autowired
    private DefaultPasswordEncoder defaultPasswordEncoder;
 
    /**
     * 用户服务类
     */
    @Autowired
    private UserDetailsService userDetailsService;
 
    /**
     * 配置设置，设置退出的地址和token
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                //未授权处理
                .authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and().authorizeRequests()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .logout().logoutUrl("/logout")
                .and()
                //.addLogoutHandler(new TokenLogoutHandler(tokenManager))
                .addFilter(new TokenLoginFilter(authenticationManager()))
                .addFilter(new TokenAuthenticationFilter(authenticationManager())).httpBasic();
    }
 
    /**
     * 密码处理
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(defaultPasswordEncoder);
    }
 
    /**
     * 配置哪些请求不拦截
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index**", "/api/**", "/swagger-ui.html/**");
    }
}
3.3 创建认证授权相关的工具类
（1）DefaultPasswordEncoder：密码处理的方法

package com.oyc.security.util;
 
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
 
/**
 * @ClassName: DefaultPasswordEncoder
 * @Description: DefaultPasswordEncoder
 * @Author oyc
 * @Date 2021/1/18 10:58
 * @Version 1.0
 */
@Component
@Slf4j
public class DefaultPasswordEncoder extends BCryptPasswordEncoder {
 
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }
 
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        if (encodedPassword == null || encodedPassword.length() == 0) {
            log.error("Empty encoded password");
            throw new IllegalArgumentException("encodedPassword is null");
        }
        return encodedPassword.equals(rawPassword);
    }
}
（2）JwtTokenUtil：token 操作的工具类

package com.oyc.security.util;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
 
import java.util.Date;
 
/**
 * @ClassName: TokenManager
 * @Description: TokenManager
 * @Author oyc
 * @Date 2021/1/18 10:58
 * @Version 1.0
 */
public class JwtTokenUtil {
    private static long tokenExpiration = 24 * 60 * 60 * 1000;
    private static String tokenSignKey = "123456";
    private static String userRoleKey = "userRole";
 
    public String createToken(String userName) {
        String token = Jwts.builder().setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(SignatureAlgorithm.HS512, tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }
 
    public static String createToken(String userName, String role) {
        String token = Jwts.builder().setSubject(userName)
                .claim(userRoleKey, role)
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(SignatureAlgorithm.HS512, tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }
 
    public static String getUserNameFromToken(String token) {
        String userName = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
        return userName;
    }
 
    public static String getUserRoleFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody();
        return claims.get(userRoleKey).toString();
    }
 
}
（3）ResponseUtil ：接口响应工具类
package com.oyc.security.util;
 
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
 
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
 
/**
 * @ClassName: ResponseUtil
 * @Description: ResponseUtil
 * @Author oyc
 * @Date 2020/12/29 20:14
 * @Version 1.0
 */
public class ResponseUtil {
    public static void out(HttpServletResponse response, Result result) {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = null;
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try {
            writer = response.getWriter();
            mapper.writeValue(writer, result);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
3.4 创建认证和授权的 filter
（1）TokenLoginFilter：认证的 filter
package com.oyc.security.filter;
 
import com.oyc.security.util.JwtTokenUtil;
import com.oyc.security.util.ResponseUtil;
import com.oyc.security.util.Result;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;
 
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
 
/**
 * @ClassName: TokenAuthenticationFilter
 * @Description: TokenAuthenticationFilter
 * @Author oyc
 * @Date 2021/1/18 10:59
 * @Version 1.0
 */
public class TokenAuthenticationFilter extends BasicAuthenticationFilter {
 
    public TokenAuthenticationFilter(AuthenticationManager authManager) {
        super(authManager);
    }
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("=================" + request.getRequestURI());
        //不需要鉴权
        if (request.getRequestURI().indexOf("index") != -1) {
            chain.doFilter(request, response);
        }
        UsernamePasswordAuthenticationToken authentication = null;
        try {
            authentication = getAuthentication(request);
        } catch (Exception e) {
            ResponseUtil.out(response, Result.error(e.getMessage()));
        }
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            ResponseUtil.out(response, Result.error("鉴权失败"));
        }
        chain.doFilter(request, response);
    }
 
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        // 获取Token字符串，token 置于 header 里
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            token = request.getParameter("token");
        }
        if (token != null && !"".equals(token.trim())) {
            // 从Token中解密获取用户名
            String userName = JwtTokenUtil.getUserNameFromToken(token);
 
            if (userName != null) {
                // 从Token中解密获取用户角色
                String role = JwtTokenUtil.getUserRoleFromToken(token);
                // 将ROLE_XXX,ROLE_YYY格式的角色字符串转换为数组
                String[] roles = role.split(",");
                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                for (String s : roles) {
                    authorities.add(new SimpleGrantedAuthority(s));
                }
                return new UsernamePasswordAuthenticationToken(userName, token, authorities);
            }
            return null;
        }
        return null;
    }
}
（2）TokenAuthenticationFilter：授权 filter
 
 
package com.oyc.security.filter;
 
import com.oyc.security.util.JwtTokenUtil;
import com.oyc.security.util.ResponseUtil;
import com.oyc.security.util.Result;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;
 
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
 
/**
 * @ClassName: TokenAuthenticationFilter
 * @Description: TokenAuthenticationFilter
 * @Author oyc
 * @Date 2021/1/18 10:59
 * @Version 1.0
 */
public class TokenAuthenticationFilter extends BasicAuthenticationFilter {
 
    public TokenAuthenticationFilter(AuthenticationManager authManager) {
        super(authManager);
    }
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("=================" + request.getRequestURI());
        //不需要鉴权
        if (request.getRequestURI().indexOf("index") != -1) {
            chain.doFilter(request, response);
        }
        UsernamePasswordAuthenticationToken authentication = null;
        try {
            authentication = getAuthentication(request);
        } catch (Exception e) {
            ResponseUtil.out(response, Result.error(e.getMessage()));
        }
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            ResponseUtil.out(response, Result.error("鉴权失败"));
        }
        chain.doFilter(request, response);
    }
 
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        // 获取Token字符串，token 置于 header 里
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            token = request.getParameter("token");
        }
        if (token != null && !"".equals(token.trim())) {
            // 从Token中解密获取用户名
            String userName = JwtTokenUtil.getUserNameFromToken(token);
 
            if (userName != null) {
                // 从Token中解密获取用户角色
                String role = JwtTokenUtil.getUserRoleFromToken(token);
                // 将ROLE_XXX,ROLE_YYY格式的角色字符串转换为数组
                String[] roles = role.split(",");
                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                for (String s : roles) {
                    authorities.add(new SimpleGrantedAuthority(s));
                }
                return new UsernamePasswordAuthenticationToken(userName, token, authorities);
            }
            return null;
        }
        return null;
    }
}
3.5 UnauthorizedEntryPoint：未授权统一处理handler
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseUtil.out(response, Result.error("未授权统一处理"));
    }
}
3.6 测试控制类
package com.oyc.security.controller;
 
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
/**
 * @ClassName: TestController
 * @Description: TestController
 * @Author oyc
 * @Date 2021/1/18 11:06
 * @Version 1.0
 */
@RestController
public class TestController {
 
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
     *
     * @return
     */
    @GetMapping("roleAdmin")
    @Secured("ROLE_ADMIN")
    public String roleAdmin() {
        return "roleAdmin!!!";
    }
 
    /**
     * 方法执行前鉴权
     *
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
     *
     * @return
     */
    @GetMapping("postAuthorize")
    @PostAuthorize("hasAnyRole('ROLE_USER')")
    public String postAuthorize() {
        System.out.println("postAuthorize…………");
        return "PostAuthorize!!!";
    }
}
3.7 测试
登录返回token：



校验登录状态：



四、SpringSecurity 原理总结
4.1 SpringSecurity 的过滤器介绍
SpringSecurity 采用的是责任链的设计模式，它有一条很长的过滤器链。现在对这条过滤器链的 15 个过滤器进行说明:
（1） WebAsyncManagerIntegrationFilter：将 Security 上下文与 Spring Web 中用于处理异步请求映射的 WebAsyncManager 进行集成。
（2） SecurityContextPersistenceFilter：在每次请求处理之前将该请求相关的安全上下文信息加载到 SecurityContextHolder 中，然后在该次请求处理完成之后，将SecurityContextHolder 中关于这次请求的信息存储到一个“仓储”中，然后将SecurityContextHolder 中的信息清除，例如在 Session 中维护一个用户的安全信 息就是这个过滤器处理的。
（3） HeaderWriterFilter：用于将头信息加入响应中。
（4） CsrfFilter：用于处理跨站请求伪造。
（5）LogoutFilter：用于处理退出登录。
（6）UsernamePasswordAuthenticationFilter：用于处理基于表单的登录请求，从表单中获取用户名和密码。默认情况下处理来自 /login 的请求。从表单中获取用户名和密码时，默认使用的表单 name 值为 username 和 password，这两个值可以通过设置这个过滤器的 usernameParameter 和 passwordParameter 两个参数的值进行修改。
（7）DefaultLoginPageGeneratingFilter：如果没有配置登录页面，那系统初始化时就会配置这个过滤器，并且用于在需要进行登录时生成一个登录表单页面。
（8）BasicAuthenticationFilter：检测和处理 http basic 认证。
（9）RequestCacheAwareFilter：用来处理请求的缓存。
（10）SecurityContextHolderAwareRequestFilter：主要是包装请求对象 request。
（11）AnonymousAuthenticationFilter：检测 SecurityContextHolder 中是否存在
Authentication 对象，如果不存在为其提供一个匿名 Authentication。
（12）SessionManagementFilter：管理 session 的过滤器
（13）ExceptionTranslationFilter：处理 AccessDeniedException 和
AuthenticationException 异常。
（14）FilterSecurityInterceptor：可以看做过滤器链的出口。
（15）RememberMeAuthenticationFilter：当用户没有登录而直接访问资源时, 从 cookie里找出用户的信息, 如果 Spring Security 能够识别出用户提供的 remember me cookie, 用户将不必填写用户名和密码, 而是直接登录进入系统，该过滤器默认不开启。 
 
4.2 SpringSecurity 基本流程
Spring Security 采取过滤链实现认证与授权，只有当前过滤器通过，才能进入下一个
过滤器：

绿色部分是认证过滤器，需要我们自己配置，可以配置多个认证过滤器。认证过滤器可以使用 Spring Security 提供的认证过滤器，也可以自定义过滤器（例如：短信验证）。认证过滤器要在 configure(HttpSecurity http)方法中配置，没有配置不生效。下面会重点介绍以下三个过滤器：

UsernamePasswordAuthenticationFilter 过滤器：该过滤器会拦截前端提交的 POST 方式的登录表单请求，并进行身份认证。

ExceptionTranslationFilter 过滤器：该过滤器不需要我们配置，对于前端提交的请求会直接放行，捕获后续抛出的异常并进行处理（例如：权限访问限制）。
 
FilterSecurityInterceptor 过滤器：该过滤器是过滤器链的最后一个过滤器，根据资源权限配置来判断当前请求是否有权限访问对应的资源。如果访问受限会抛出相关异常，并由 ExceptionTranslationFilter 过滤器进行捕获和处理。
 
4.3 SpringSecurity 认证流程
认证流程是在 UsernamePasswordAuthenticationFilter 过滤器中处理的，具体流程如下
所示：


 

对应源码：https://github.com/oycyqr/springboot-learning-demo/tree/master/springboot-security-token
