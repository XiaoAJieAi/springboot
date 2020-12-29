package com.n22.springboot.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.n22.springboot.exception.UserNotExistException;

@ControllerAdvice
public class ControllerExceptionHandler {

	// 指定了要处理的异常类型
	@ExceptionHandler(UserNotExistException.class)
	@ResponseBody
	// 指定异常处理方法返回的HTTP状态码
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String,Object> handleUserNotExistsException(UserNotExistException e){
		Map<String, Object> map = new HashMap<>();
		map.put("id", e.getId());
		map.put("message", e.getMessage());
		return map;
	}
	
}
