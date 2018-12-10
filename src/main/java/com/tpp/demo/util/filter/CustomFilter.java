/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.tpp.demo.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author wujing
 */
@WebFilter(filterName = "customFilter", urlPatterns = "/*")
public class CustomFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init filter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("do filter");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("destroy filter");
	}

}
