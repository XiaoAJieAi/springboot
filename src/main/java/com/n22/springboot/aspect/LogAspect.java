package com.n22.springboot.aspect;

import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import com.n22.springboot.config.Log;
import com.n22.springboot.dao.db1.SysLogDao;
import com.n22.springboot.model.SysLog;

@Aspect
@Component
public class LogAspect {

	@Autowired
	private SysLogDao sysLogDao;
	
	@Pointcut("@annotation(com.n22.springboot.config.Log)")
	public void point() {}
	
	@Around("point()")
	public Object around(ProceedingJoinPoint point) {
		Object result = null;
		long beginTime = System.currentTimeMillis();
		// 执行方法
		try {
			result = point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// 执行时长（毫秒）
		long time = System.currentTimeMillis() - beginTime;
		// 保存日志
		saveLog(point,time);
		return result;
		
	}

	private void saveLog(ProceedingJoinPoint point, long time) {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();
		SysLog sysLog = new SysLog();
		Log LogAnnotation = method.getAnnotation(Log.class);
		if(LogAnnotation != null) {
			// 注解上的描述
			sysLog.setOperation(LogAnnotation.value());
		}
		// 请求的方法名
		String className = point.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className+"."+methodName+"()");
		
		// 请求的方法参数值
		Object[] args = point.getArgs();
		// 请求的方法参数名称
		LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
		String[] paramNames = u.getParameterNames(method);
		if(args != null && paramNames != null) {
			String params = "";
			for (int i = 0; i < args.length; i++) {
				params+=" "+paramNames[i]+": "+args[i];
			}
			sysLog.setParams(params);
		}
		
		
		try {
			// 获取ip地址
			InetAddress ip4 = Inet4Address.getLocalHost();
			// 设置IP地址
			sysLog.setIp(ip4.getHostAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 模拟一个用户名
		sysLog.setUsername("mrbird");
		sysLog.setTime((int)time);
		sysLog.setCreateTime(new Date());
		
		sysLogDao.saveSysLog(sysLog);
	}
	
}
