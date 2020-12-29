package com.n22.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.n22.springboot.exception.UserNotExistException;
import com.n22.springboot.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
		return "hello spring boot !!!";
	}
	
	@GetMapping("/test/{id}")
	public void get(@PathVariable String id) {
		throw new UserNotExistException(id);
	}
	
	@ApiOperation(value = "获取用户信息",notes = "根据用户id获取用户信息")
	@ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "int",paramType = "path")
	@GetMapping("/{id}")
	@ResponseBody
	public User getUserById(@PathVariable("id") int id) {
		User user = new User();
		user.setId(id);
		user.setUserName("XiaoAJie");
		user.setAge(25);
		return user;
	}
	
	@ApiOperation(value = "获取用户列表",notes = "获取用户列表")
	@GetMapping("/list")
	@ResponseBody
	public List<User> getUserList(){
		List<User> list = new ArrayList<>();
		User user1 =new User();
		user1.setId(11);
		user1.setUserName("mrbird");
		user1.setAge(25);
		list.add(user1);
		User user2 =new User();
		user2.setId(21);
		user2.setUserName("scott");
		user2.setAge(29);
		list.add(user2);
		return list;
	}
	
	
	@ApiOperation(value = "新增用户",notes = "根据用户实体创建用户")
	@ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
	@PostMapping
	@ResponseBody
	public Map<String,Object> addUser(@RequestBody User user){
		Map<String,Object> map = new HashMap<>();
		map.put("result", user);
		return map;
	}
	
	@ApiOperation(value = "删除用户",notes = "根据用户id删除用户")
	@ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "int",paramType = "path")
	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String,Object> deleteUser(@PathVariable("id") int id){
		Map<String,Object> map = new HashMap<>();
		map.put("result", id);
		return map;
	}
	
	@ApiOperation(value = "更新用户",notes = "根据用户id更新用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "int",paramType = "path"),
		@ApiImplicitParam(name = "user",value = "用户实体",required = true,dataType = "User")
	})
	@PutMapping("/{id}")
	@ResponseBody
	public Map<String,Object> updateUser(@PathVariable("id") int id,@RequestBody User user){
		Map<String,Object> map = new HashMap<>();
		map.put("result", id);
		map.put("user", user);
		return map;
	}
	
	
}
