package com.n22.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.n22.springboot.model.Student;
import com.n22.springboot.service.db.StudentServiceDB;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class StudentController {

	@Autowired
	private StudentServiceDB studentServiceDB;
	
	
	@RequestMapping(value = "/getAllStudentsByMaybatisDB1",method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getAllStudentsByMaybatisDB1(){
		return studentServiceDB.getAllStudentsByMaybatisDB1();
	}
	
	@RequestMapping(value = "/getAllStudentsByMaybatisDB2",method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getAllStudentsByMaybatisDB2(){
		return studentServiceDB.getAllStudentsByMaybatisDB2();
	}
}
