package com.mycompany.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT")
public class Patient extends User
{
	@Id
	@GeneratedValue  
	protected int id;
	private int height;
	private int weight;
	@OneToOne(cascade=CascadeType.ALL)
	private Appointment appointment;
	@ManyToOne(cascade=CascadeType.ALL)
	private Doctor doctor;
	@OneToOne(cascade=CascadeType.ALL)
	private HealthParameters healthparameters;
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public HealthParameters getHealthparameters() {
		return healthparameters;
	}
	public void setHealthparameters(HealthParameters healthparameters) {
		this.healthparameters = healthparameters;
	}
	
	public Patient()
	{
		
	}
	
	public Patient(String userName, String password, String firstName, String lastName, int age, String gender,
			String telephone, String email,int height, int weight) {
		super(userName, password, firstName, lastName, age, gender, telephone, email);
		this.height = height;
		this.weight = weight;
	}
}