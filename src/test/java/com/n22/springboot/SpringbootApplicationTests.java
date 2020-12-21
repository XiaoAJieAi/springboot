package com.n22.springboot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.n22.springboot.model.Student;
import com.n22.springboot.service.db.StudentServiceDB;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootApplicationTests {

	@Autowired
	private StudentServiceDB studentServiceDB;
	@Test
	void test() {
		List<Student> maybatisDB1 = studentServiceDB.getAllStudentsByMaybatisDB1();
		for (Student student : maybatisDB1) {
			System.out.println(student.toString());
		}
	}
	
	@Test
	void test1() {
		Student student = new Student();
		student.setSno("001");
		Student student1 = studentServiceDB.selectStudentBySno(student);
		System.out.println(student1.toString());
		
		student.setName("lalalal");
		studentServiceDB.update(student);
		
		Student student2 = studentServiceDB.selectStudentBySno(student);
		System.out.println(student2.toString());
	}


}
