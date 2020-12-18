package com.n22.springboot.service.db.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n22.springboot.model.Student;
import com.n22.springboot.service.db.StudentServiceDB;

@Service("studentServiceDB")
public class StudentServiceDBImpl implements StudentServiceDB {

	
	@Autowired
	private com.n22.springboot.dao.db1.StudentMapper studentMapperDB1;
	
	@Autowired
	private com.n22.springboot.dao.db2.StudentMapper studentMapperDB2;
	
	@Override
	public List<Student> getAllStudentsByMaybatisDB1() {
		return studentMapperDB1.getAllStudents();
	}

	@Override
	public List<Student> getAllStudentsByMaybatisDB2() {
		return studentMapperDB2.getAllStudents();
	}

	@Override
	public Student selectStudentBySno(Student student) {
		return studentMapperDB1.selectStudentBySno(student);
	}

	@Override
	public Student update(Student student) {
		studentMapperDB1.update(student);
		return studentMapperDB1.selectStudentBySno(student);
	}

	@Override
	public void deleteStudentBySno(String sno) {
		studentMapperDB1.deleteStudentBySno(sno);
	}
}
