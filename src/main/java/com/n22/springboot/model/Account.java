package com.n22.springboot.model;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 6825692808143341510L;

	private String no;
	private String account;
	private String name;
	private String password;
	private String accountType;
	private String tel;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Account(String no, String account, String name, String password, String accountType, String tel) {
		super();
		this.no = no;
		this.account = account;
		this.name = name;
		this.password = password;
		this.accountType = accountType;
		this.tel = tel;
	}
	public Account() {
		super();
	}
	
	
}
