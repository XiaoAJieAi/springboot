package com.n22.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.n22.springboot.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api("用户Controller")
@Controller
@RequestMapping("/user")
public class UserController {

	@ApiIgnore
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	@ApiOperation(value = "获取用户信息",notes = "根据用户id获取用户信息")
	@ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Integer",paramType = "path")
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		User user = new User();
		user.setId(id);
		user.setUserName("XiaoAJie");
		user.setAge(25);
		return user;
	}
}
