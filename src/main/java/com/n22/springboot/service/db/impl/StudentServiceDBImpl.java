package com.n22.springboot.service.db.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n22.springboot.service.db.StudentServiceDB;

@Service("studentServiceDB")
public class StudentServiceDBImpl implements StudentServiceDB {

	
	@Autowired
	private com.n22.springboot.dao.db1.StudentMapper studentMapperDB1;
	
	@Autowired
	private com.n22.springboot.dao.db2.StudentMapper studentMapperDB2;
	
	@Override
	public List<Map<String, Object>> getAllStudentsByMaybatisDB1() {
		return studentMapperDB1.getAllStudents();
	}

	@Override
	public List<Map<String, Object>> getAllStudentsByMaybatisDB2() {
		return studentMapperDB2.getAllStudents();
	}
}
