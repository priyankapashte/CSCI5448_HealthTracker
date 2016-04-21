package com.mycompany.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Inheritance;  
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass; 

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class User {
	
	protected String userName;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected int age;
	protected String gender;
	protected String telephone;
	protected String email;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User(String userName, String password, String firstName, String lastName, int age, String gender,
			String telephone, String email) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.telephone = telephone;
		this.email = email;

	}	
	public User() 
	{
	
	}
}