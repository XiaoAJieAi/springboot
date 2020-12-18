package com.n22.springboot.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.n22.springboot.model.User;

@Controller
public class JsonTestController {
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser() {
		User user = new User();
		user.setUserName("XiaoAjie");
		user.setBirthday(new Date());
		return user;
	}
}
