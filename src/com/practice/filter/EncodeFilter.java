package com.practice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
* 	编码过滤器类，解决中文乱码
* 	@author Albert
*/
public class EncodeFilter implements Filter {

	private FilterConfig filterConfig;
	@Override
	public void destroy() {


	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(filterConfig.getInitParameter("charset"));
		response.setCharacterEncoding(filterConfig.getInitParameter("charset"));
		response.setContentType(filterConfig.getInitParameter("contenttype"));
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}



}
