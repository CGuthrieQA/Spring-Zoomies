package com.qa.springcars.domain;

public class Car {

	// Variables
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
