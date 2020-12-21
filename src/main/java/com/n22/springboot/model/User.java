package com.n22.springboot.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.n22.springboot.serializer.UserDeserializer;
import com.n22.springboot.serializer.UserSerializer;

// 忽略一组属性，作用于类上
//@JsonIgnoreProperties({"password"})
// 用于指定一个命名策略，作用于类或者属性上。
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
// 使用注解@JsonSerialize来指定User对象的序列化方式
//@JsonSerialize(using=UserSerializer.class)
// 使用注解@JsonDeserialize来指定User对象的反序列化方式
//@JsonDeserialize(using=UserDeserializer.class)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public interface UserNameView{};
	public interface AllUserFieldView extends UserNameView{};
	
	private Integer id;

	//@JsonView(UserNameView.class)
	private String userName;
	//@JsonView(AllUserFieldView.class)
	private Integer age;
	// @JsonIgnore 作用在属性上，用来忽略此属性。
	//@JsonView(AllUserFieldView.class)
	private String password;
	// 作用在属性上，用来为JSON Key指定一个别名。
	//@JsonProperty("bth") 
	// 用于日期格式化
	@JsonFormat(pattern = "yyyy-MM-dd")
	//@JsonView(AllUserFieldView.class)
	private Date birthday;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	
	public User(Integer id, String userName, Integer age, String password, Date birthday) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.password = password;
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", age=" + age + ", password=" + password + ", birthday="
				+ birthday + "]";
	}
	public User() {
		super();
	}
	
	
}
