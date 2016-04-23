package com.mycompany.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENT")
public class Appointment {
	@Id
	@GeneratedValue 
	private int id;
	@ManyToOne(cascade=CascadeType.ALL)
	private Doctor doctor;
	@OneToOne(cascade=CascadeType.ALL)
	private Patient patient;
	private Date dateTime;
	
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Appointment()
	{
		
	}
}