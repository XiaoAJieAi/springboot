package com.n22.springboot.model;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = -8939235242290744012L;
	
	private String sno;
	private String name;
	private String sex;
	private String database;
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	
	public Student(String sno, String name, String sex, String database) {
		super();
		this.sno = sno;
		this.name = name;
		this.sex = sex;
		this.database = database;
	}
	
	public Student() {
		super();
	}
	
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", sex=" + sex + ", database=" + database + "]";
	}
	
}
