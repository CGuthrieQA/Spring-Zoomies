package com.qa.springcars.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	// Variables
	@Id // Primary Key!
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	private Long id;
	
	private String make;
	
	private String model;
	
	private int engine;
	
	private boolean spoiler;
	
	// Methods
	
	// Constructors
	
	// Default Constructor
	public Car() {
	}
	
	// All Arguments Constructor
	public Car(String make, String model, int engine, boolean spoiler) {
		this.make = make;
		this.model = model;
		this.engine = engine;
		this.spoiler = spoiler;
	}
	
	// Getters
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public int getEngine() {
		return engine;
	}
	public boolean isSpoiler() {
		return spoiler;
	}
	
	// Setters
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setEngine(int engine) {
		this.engine = engine;
	}
	public void setSpoiler(boolean spoiler) {
		this.spoiler = spoiler;
	}
	
}
