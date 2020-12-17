package com.n22.springboot.dao.db1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository("studentMapperDB1")
public interface StudentMapper {
	
	public List<Map<String,Object>> getAllStudents();
}
