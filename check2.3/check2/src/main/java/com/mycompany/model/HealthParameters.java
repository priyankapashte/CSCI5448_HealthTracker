package com.mycompany.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HEALTHPARAMETERS")
public class HealthParameters {
	@Id
	@GeneratedValue 
	private int id;
	private int avgHeartrate;
	private int sleep;
	private int calories;
	private int[] heartrateArray;
	
	public int getAvgHeartrate() {
		return avgHeartrate;
	}
	public HealthParameters(int avgHeartrate, int sleep, int calories, int[] heartrateArray) {
		super();
		this.avgHeartrate = avgHeartrate;
		this.sleep = sleep;
		this.calories = calories;
		this.heartrateArray = heartrateArray;
	}
	public void setAvgHeartrate(int avgHeartrate) {
		this.avgHeartrate = avgHeartrate;
	}
	public int getSleep() {
		return sleep;
	}
	public void setSleep(int sleep) {
		this.sleep = sleep;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int[] getHeartrateArray() {
		return heartrateArray;
	}
	public void setHeartrateArray(int[] heartrateArray) {
		this.heartrateArray = heartrateArray;
	}
	
	public HealthParameters()
	{
		
	}
}