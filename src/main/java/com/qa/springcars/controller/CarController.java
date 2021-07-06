package com.qa.springcars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springcars.domain.Car;

@RestController
public class CarController {
	
	// Mapping URLs to METHODS
	
	List<Car> vehicles = new ArrayList<>();
	
	// CRUD Functionality
	
	// CREATE
	@PostMapping("/create")
	public String carCreate(@RequestBody Car c) {
		this.vehicles.add(c);
		return "Successfully added car";
	}
	
	// READ
	
		// All
	@GetMapping("/read")
	public List<Car> carReadAll(){
		return this.vehicles;
	}
	
	// ById
	@GetMapping("/read/{index}")
	public Car carReadByIndex(@PathVariable int index) {
		return this.vehicles.get(index);
	}
	
	// UPDATE - PUT (REPLACE) / PATCH (UPDATE an ELEMENT)
	@PatchMapping("/update/{index}")
	public Car carUpdate(@PathVariable int index, @RequestBody Car newCar) {
		
//		Car toUpdate = this.vehicles.get(index);
//		toUpdate.setMake(newCar.getMake());
//		toUpdate.setModel(newCar.getModel());
//		toUpdate.setEngine(newCar.getEngine());
//		toUpdate.setSpoiler(newCar.isSpoiler());
//		return toUpdate;
		
		this.vehicles.set(index, newCar);
		return this.vehicles.get(index);
		
	}
	
	// DELETE - By Index
	@DeleteMapping("/delete/{index}")
	public String carDelete(@PathVariable int index) {
		this.vehicles.remove(index);
		return "Successfully deleted car";
	}
	
}
