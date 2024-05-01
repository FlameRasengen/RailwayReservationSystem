package com.railway.railway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERSINFO")
public class UsersInfo {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	private String username;
	private String password;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDetails [user_id=" + user_id + ", username=" + username + ", password=" + password + "]";
	}
	public UsersInfo(Integer user_id, String username, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
	}
	public UsersInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
