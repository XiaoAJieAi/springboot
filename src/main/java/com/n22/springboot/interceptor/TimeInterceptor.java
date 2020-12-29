package com.n22.springboot.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("处理拦截之前");
		request.setAttribute("startTime", new Date().getTime());
		HandlerMethod handlerMethod =(HandlerMethod) handler;
		System.out.println(handlerMethod.getBean().getClass().getName());
		System.out.println(handlerMethod.getMethod().getName());
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("开始处理拦截");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("【拦截器】耗时 " + (new Date().getTime() - start));
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("处理拦截器之后");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("【拦截器】耗时"+(new Date().getTime()-start));
		System.out.println("异常信息"+ex);
	}
}
