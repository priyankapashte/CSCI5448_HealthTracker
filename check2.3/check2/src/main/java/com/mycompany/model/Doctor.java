package com.mycompany.model;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import antlr.collections.List;

import java.util.*;

@Entity
@Table(name="DOCTOR")
public class Doctor extends User {
	public Doctor(String userName, String password, String firstName, String lastName, int age, String gender,
			String telephone, String email, String location, String specialization, String day, String time) {
		super(userName, password, firstName, lastName, age, gender, telephone, email);
		this.location=location;
		this.specialization=specialization;
		this.day=day;
		this.time=time;
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue  
	protected int id;
	private String location;
	private String specialization;
	private String day;
	private String time;
	private ArrayList<Patient> patients;
	private ArrayList<Appointment> appointments;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public ArrayList<Patient> getPatients() {
		return patients;
	}
	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	public Doctor()
	{
		
	}
}