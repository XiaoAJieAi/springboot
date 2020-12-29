package com.n22.springboot.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.stereotype.Component;

/**
 * 自定义一个Timefilter过滤器
 * @author zjw_guosj
 *
 */
@Component
@WebFilter(urlPatterns = {"/*"})
public class TimeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("开始执行过滤器");
		long start = new Date().getTime();
		chain.doFilter(request, response);
		System.out.println("【过滤器】耗时 " + (new Date().getTime() - start));
		System.out.println("结束执行过滤器");
	}

	
	@Override
	public void destroy() {
		System.out.println("过滤器销毁");
	}

}
