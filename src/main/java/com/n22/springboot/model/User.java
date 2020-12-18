package com.n22.springboot.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;
	private Integer age;
	private String password;
	private Date birthday;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + ", password=" + password + ", birthday=" + birthday
				+ "]";
	}
	public User(String userName, Integer age, String password, Date birthday) {
		super();
		this.userName = userName;
		this.age = age;
		this.password = password;
		this.birthday = birthday;
	}
	
	public User() {
		super();
	}
	
	
}
