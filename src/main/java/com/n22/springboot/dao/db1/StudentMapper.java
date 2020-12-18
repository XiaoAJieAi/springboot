package com.n22.springboot.dao.db1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.n22.springboot.model.Student;

//@Mapper
@Repository("studentMapperDB1")
public interface StudentMapper {
	
	public List<Student> getAllStudents();
	
	public Student update(Student student);
	
	public void deleteStudentBySno(String sno);

	public Student selectStudentBySno(Student student);
}
