package com.dukepu.entity;

import javax.persistence.*;
/*
 * password, 
update_time, 
department, 
action, 
user_name, 
product_name
*/


@Entity
public class User_Info {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sequence;
	@Column(length=50)
	private String user_name;
	@Column(length = 50)
	private String password;
	@Column(length=50)
	private String department;
	@Column(length=50)
	private String product_name;
	@Column(length=50)
	private String action;
	@Column(length=50)
	private String update_time;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
