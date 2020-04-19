**一、过滤器（Filter）的介绍**

Filter也称为过滤器，是处于客户端与服务器资源文件之间的一道过滤网，它是Servlet技术中最激动人心的技术之一。Web开发人员通过Filter技术管理Web服务器
的所有资源，例如对JSP、Servlet、静态资源等进行拦截，从而实现一些特殊功能，如权限访问控制、过滤敏感词汇、压缩相应信息等一些高级功能。


**二、Servlet 的 Filter 接口需要实现如下方法：**

void init(FilterConfig paramFilterConfig) – 当容器初始化 Filter 时调用，该方法在 Filter 的生命周期只会被调用一次，一般在该方法中初始化一些资源，FilterConfig 是容器提供给 Filter 的初始化参数，在该方法中可以抛出 ServletException 。init 方法必须执行成功，否则 Filter 可能不起作用，出现以下两种情况时，web 容器中 Filter 可能无效： 1）抛出 ServletException 2）超过 web 容器定义的执行时间。
doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse, FilterChain paramFilterChain) – Web 容器每一次请求都会调用该方法。该方法将容器的请求和响应作为参数传递进来， FilterChain 用来调用下一个 Filter。
void destroy() – 当容器销毁 Filter 实例时调用该方法，可以在方法中销毁资源，该方法在 Filter 的生命周期只会被调用一次。


**三、SpringBoot中使用Filter**

3.1 实现Filter并在类上添加@WebFiler注解
3.2 在启动类中添加@ServletComponentScan注解