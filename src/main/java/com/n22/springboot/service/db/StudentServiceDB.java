package com.n22.springboot.service.db;

import java.util.List;
import java.util.Map;


public interface StudentServiceDB {

	public List<Map<String, Object>> getAllStudentsByMaybatisDB1();
	public List<Map<String, Object>> getAllStudentsByMaybatisDB2();

}
