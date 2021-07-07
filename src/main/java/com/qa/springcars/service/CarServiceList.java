package com.qa.springcars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springcars.domain.Car;

@Service // contains main business logic of our application!
public class CarServiceList {

	private List<Car> vehicles = new ArrayList<>();
	
	// METHODS TO MANIPULATE THE LIST
	
	// CREATE - a method to add to the list
	public String carCreate(Car c) {
		this.vehicles.add(c);
		return "Successfully added car";
	}
	
	// READ - a method to read from the list
	public List<Car> carReadAll(){
		return this.vehicles;
	}
	
	// UPDATE - a method to replace an existing entry
	public Car carUpdate(int index, Car newCar) {
		this.vehicles.set(index, newCar);
		return this.vehicles.get(index);
	}
	
	// DELETE - a method to remove an entry
	public boolean carDelete(int index) {
		this.vehicles.remove(index);
		return true;
	}
	
}
