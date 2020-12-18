package com.n22.springboot.dao.db2;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.n22.springboot.model.Student;

//@Mapper
@Repository("studentMapperDB2")
public interface StudentMapper {
	
	public List<Student> getAllStudents();
}
