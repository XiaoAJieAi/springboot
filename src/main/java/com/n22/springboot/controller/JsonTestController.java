package com.n22.springboot.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.n22.springboot.model.User;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class JsonTestController {
	
	@Autowired
	private ObjectMapper mapper;
	
	@JsonView(User.UserNameView.class)
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser() {
		User user = new User();
		user.setUserName("XiaoAjie");
		user.setBirthday(new Date());
		return user;
	}
	
	@JsonView(User.AllUserFieldView.class)
	@RequestMapping("/serialization")
	@ResponseBody
	public String serialization() {
		try {
			User user = new User();
			user.setUserName("XiaoAjieAi");
			user.setBirthday(new Date());
			String writeValueAsString = mapper.writeValueAsString(user);
			return writeValueAsString;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("/readJsonString")
	@ResponseBody
	public String readJsonString() {
		try {
			String json = "{\"name\":\"XiaoAJieJson\",\"age\":26}";
			JsonNode readTree = mapper.readTree(json);
			String name = readTree.get("name").asText();
			int age = readTree.get("age").asInt();
			return name+" "+age;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("/readJsonAsObject")
	@ResponseBody
	public String readJsonAsObject() {
		try {
			String json = "{\"userName\":\"XiaoAJieJson\",\"age\":26}";
			User user = mapper.readValue(json, User.class);
			String name = user.getUserName();
			int age = user.getAge();
			return name+" "+age;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("/readJsonAsObjectDeserializer")
	@ResponseBody
	public String readJsonAsObjectDeserializer() {
		try {
			String json = "{\"user_name\":\"XiaoAJieJson\",\"age\":26}";
			User user = mapper.readValue(json, User.class);
			String name = user.getUserName();
			Integer age = user.getAge();
			return name+" "+age;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/customize")
	@ResponseBody
	public String customize() throws JsonParseException, JsonMappingException, IOException {
	    String jsonStr = "[{\"userName\":\"mrbird\",\"age\":26},{\"userName\":\"scott\",\"age\":27}]";
	    JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, User.class);
		List<User> list = mapper.readValue(jsonStr, javaType);
	    String msg = "";
	    for (User user : list) {
	        msg += user.getUserName();
	    }
	    return msg;
	}
}
