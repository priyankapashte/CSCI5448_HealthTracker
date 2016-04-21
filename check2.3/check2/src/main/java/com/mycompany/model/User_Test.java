package com.mycompany.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_INFORMATION")
public class User_Test {
	@Id
	@GeneratedValue
	private long userID;
	private String username;
	private String password;
	
	public User_Test()
	{
		
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
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
	
	

}
