package com.n22.springboot.service.db;

import java.util.List;


import com.n22.springboot.model.Student;


public interface StudentServiceDB {

	public List<Student> getAllStudentsByMaybatisDB1();
	public List<Student> getAllStudentsByMaybatisDB2();
	public Student selectStudentBySno(Student student);
	public Student update(Student student);
	public void deleteStudentBySno(String sno);

}
