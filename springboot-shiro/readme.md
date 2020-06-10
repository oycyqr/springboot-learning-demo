## 一、什么是Shiro
Shiro是一个强大的简单易用的Java安全框架，主要用来更便捷的认证，授权，加密，会话管理。Shiro首要的和最重要的目标就是容易使用并且容易理解，通过Shiro易于理解的API,您可以快速、轻松地获得任何应用程序——从最小的移动应用程序最大的网络和企业应用程序。
## 二、Shiro架构

### 2.1  Shiro架构图
 ![shiro架构图](https://img-blog.csdnimg.cn/20200605223816299.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTQ1NTMwMjk=,size_16,color_FFFFFF,t_70)
> - Authentication：身份认证/登录
> - Authorization：验证权限，即，验证某个人是否有做某件事的权限。
> - Session Management:会话管理。管理用户特定的会话，支持web,非web,ejb。
> - Cryptography: 加密，保证数据安全。
> - Web Support:web支持，更容易继承web应用。
> - Caching：缓存
> - Concurrency ：多线程应用的并发验证，即如在一个线程中开启另一个线程，能把权限自动传播过去；
> - Testing：提供测试支持。
> - Run As：允许一个用户假装为另一个用户（如果他们允许）的身份进行访问；
> - Remember Me：记住我，即记住登录状态，一次登录后，下次再来的话不用登录了 

### 2.2 Shiro 工作原理
 Shiro的架构有三个主要概念:Subject, SecurityManager 和 Realms。
![shiro工作原理](https://img-blog.csdnimg.cn/20200605230354108.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTQ1NTMwMjk=,size_16,color_FFFFFF,t_70)
- Subject: 当前参与应用安全部分的主角。可以是用户，可以试第三方服务，可以是cron 任务，或者任何东西。主要指一个正在与当前软件交互的东西。所有Subject都需要SecurityManager，当你与Subject进行交互，这些交互行为实际上被转换为与SecurityManager的交互。
- SecurityManager:安全管理员，Shiro架构的核心，它就像Shiro内部所有原件的保护伞。然而一旦配置了SecurityManager，SecurityManager就用到的比较少，开发者大部分时间都花在Subject上面。当你与Subject进行交互的时候，实际上是SecurityManager在背后帮你举起Subject来做一些安全操作。
- Realms: Realms作为Shiro和你的应用的连接桥，当需要与安全数据交互的时候，像用户账户，或者访问控制，Shiro就从一个或多个Realms中查找。Shiro提供了一些可以直接使用的Realms，如果默认的Realms不能满足你的需求，你也可以定制自己的Realms。
### 2.3 Shiro详细架构图
![Shiro详细架构](https://img-blog.csdnimg.cn/20200605230712815.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTQ1NTMwMjk=,size_16,color_FFFFFF,t_70)
- Subject：与应用交互的主体，例如用户，第三方应用等。
- SecurityManager：shiro的核心，负责整合所有的组件，使他们能够方便快捷完成某项功能。例如：身份验证，权限验证等。
- Authenticator：认证器，负责主体认证的，这是一个扩展点，如果用户觉得Shiro默认的不好，可以自定义实现；其需要认证策略（Authentication Strategy），即什么情况下算用户认证通过了。
- Authorizer：决定主体是否有权限进行相应的操作；即控制着用户能访问应用中的哪些功能。
- SessionManager：会话管理。
- SessionDAO：数据访问对象，对session进行CRUD。
- CacheManager：缓存管理器。创建和管理缓存，为 authentication, authorization 和 session management 提供缓存数据，避免直接访问数据库，提高效率。
- Cryptography；密码模块，提供加密组件。
- Realms：可以有1个或多个Realm，可以认为是安全实体数据源，即用于获取安全实体的；可以是JDBC实现，也可以是LDAP实现，或者内存实现等等；由用户提 供；注意：Shiro不知道你的用户/权限存储在哪及以何种格式存储；所以我们一般在应用中都需要实现自己的Realm。
## 三、SpringBoot 整合Shiro
### 3.1 引入依赖

```
<dependency>
    <groupId>org.apache.shiro</groupId>
    <artifactId>shiro-spring</artifactId>
    <version>1.4.0</version>
</dependency>
```
### 3.2 编写自定义Realm
```
/**
 * @Author: oyc
 * @Date: 2020-06-02 16:12
 * @Description:
 */
public class CustomRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息,此处模拟
        User user = new User(1,name,"123456");
        // 添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//添加角色
		simpleAuthorizationInfo.addRole(user.getAccount());
		//添加权限,admin:add/user:add
		simpleAuthorizationInfo.addStringPermission(user.getAccount()+":add");
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        // 根据用户名获取用户信息,此处模拟
        User user = new User(1,name,"123456");
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            return new SimpleAuthenticationInfo(name, user.getPassword(), getName());
        }
    }
}
```

### 3.3 配置Shiro
```
/**
 * @Author: oyc
 * @Date: 2020-06-02 16:11
 * @Description: Shiro 配置
 */
@Configuration
public class ShiroConfig {
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//拦截器
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/logout", "logout");
		//过滤链定义，从上向下顺序执行，一般将/**放在最为下边
		//authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/**", "authc");
		//未登录，重定向到登录页面，如果是前后端分离，不需要
		shiroFilterFactoryBean.setLoginUrl("/login");
		return shiroFilterFactoryBean;
	}

	/**
	 * 将自己的验证方式加入容器
	 */
	@Bean
	public CustomRealm myShiroRealm() {
		CustomRealm customRealm = new CustomRealm();
		return customRealm;
	}

	/**
	 * 安全管理器
	 */
	@Bean
	public SecurityManager securityManager(CustomRealm myShiroRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置realm
		securityManager.setRealm(myShiroRealm);
		return securityManager;
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
	 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
	 *
	 * @return
	 */
	@Bean
	@DependsOn({"lifecycleBeanPostProcessor"})
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager(myShiroRealm()));
		return authorizationAttributeSourceAdvisor;
	}
}
```
### 3.4 全局异常处理

```
/**
 * @Author: oyc
 * @Date: 2020-06-02 16:41
 * @Description: 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class ExceptionController {

	@ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity ErrorHandler401(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "401");
		//获取错误中中括号的内容
		String message = e.getMessage();
		String msg=message.substring(message.indexOf("[")+1,message.indexOf("]"));
		//判断是角色错误还是权限错误
		if (message.contains("role")) {
			result.put("msg", "对不起，您没有" + msg + "角色");
		} else if (message.contains("permission")) {
			result.put("msg", "对不起，您没有" + msg + "权限");
		} else {
			result.put("msg", "对不起，您的权限有误");
		}
		return new ResponseEntity(result, HttpStatus.FORBIDDEN);
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
```
链接不存在异常处理：
```
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
```

### 3.5 编写登录类
```
/**
 * @Author: oyc
 * @Date: 2020-06-02 16:39
 * @Description: 登录控制类
 */
@RestController
public class LoginController {

	@GetMapping("/login")
	public String login(User user) {
		//添加用户认证信息
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getAccount(), user.getPassword());
		try {
			//进行验证，这里可以捕获异常，然后返回对应信息
			subject.login(usernamePasswordToken);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return "账号或密码错误！";
		} catch (AuthorizationException e) {
			e.printStackTrace();
			return "没有权限！";
		}
		return "用户["+SecurityUtils.getSubject().getPrincipal()+"]登录成功";
	}

	/**
	 * 注解检验角色-admin
	 */
	@RequiresRoles("admin")
	@RequestMapping("role/admin")
	public String roleAdmin() {
		return "当前登录用户拥有admin角色";
	}

	/**
	 * 注解检验角色-user
	 */
	@RequiresRoles("user")
	@RequestMapping("role/user")
	public String roleUser() {
		return "当前登录用户拥有user角色";
	}

	/**
	 * 注解检验权限 -- admin:add
	 */
	@RequiresPermissions("admin:add")
	@RequestMapping("perm/adminAdd")
	public String userAdd() {
		return "当前登录用户拥有user:add权限";
	}

	/**
	 * 注解检验权限 -- user:add
	 */
	@RequiresPermissions("user:add")
	@RequestMapping("perm/userAdd")
	public String userView() {
		return "当前登录用户拥有user:add权限";
	}
	/**
	 * 注解检验权限 --user user:add
	 */
	@RequiresRoles("user")
	@RequiresPermissions("user:add")
	@RequestMapping("role/perm/userAdd")
	public String rolePermserAdd() {
		return "当前登录用户拥有admin角色和user:add权限";
	}
}
```
### 3.6 登录以及权限测试
用户登录admin
![admin](https://img-blog.csdnimg.cn/2020060600224058.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTQ1NTMwMjk=,size_16,color_FFFFFF,t_70)
role admin权限
![admin角色权限](https://img-blog.csdnimg.cn/20200606002521522.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTQ1NTMwMjk=,size_16,color_FFFFFF,t_70)
role user角色
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200606002818211.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTQ1NTMwMjk=,size_16,color_FFFFFF,t_70)
user:add 权限
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200606002240119.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTQ1NTMwMjk=,size_16,color_FFFFFF,t_70)
