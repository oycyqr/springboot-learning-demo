package com.oycbest.ssmblog.filter;

import com.oycbest.ssmblog.vo.Result;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: oyc
 * @Date: 2020-06-05 9:28
 * https://blog.csdn.net/weixin_42236404/article/details/89319359
 * @Description:
 */
@Component
public class ShiroLoginFilter extends FormAuthenticationFilter {

	/**
	 * 如果isAccessAllowed返回false 则执行onAccessDenied
	 * @param request
	 * @param response
	 * @param mappedValue
	 * @return
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		if (request instanceof HttpServletRequest) {
			if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
				return true;
			}
		}
		return super.isAccessAllowed(request, response, mappedValue);
	}
	/**
	 * 在访问controller前判断是否登录，返回json，不进行重定向。
	 *
	 * @param request
	 * @param response
	 * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
	 * @throws Exception
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		//这里是个坑，如果不设置的接受的访问源，那么前端都会报跨域错误，因为这里还没到corsConfig里面
		httpServletResponse.setHeader("Access-Control-Allow-Origin", ((HttpServletRequest) request).getHeader("Origin"));
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
		httpServletResponse.setCharacterEncoding("UTF-8");
		httpServletResponse.setContentType("application/json");
		Result result = Result.unAuth();
		httpServletResponse.getWriter().write(result.toString());
		return false;
	}
}
