package com.practice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 判断用户是否登录的过滤器
 * @author Albert
 *
 */
public class AuthFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hrequest =(HttpServletRequest)request;
		HttpServletResponse hresponse =(HttpServletResponse)response;

		String username = (String)hrequest.getSession().getAttribute("loginUser");
		if(username==null) {
			hresponse.sendRedirect(hrequest.getContextPath()+"/index.jsp?flag=1");
			return;
		}else {
			chain.doFilter(request, response);
			return;
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
