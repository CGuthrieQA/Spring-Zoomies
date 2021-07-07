package com.qa.springcars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springcars.domain.Car;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	// Mapping URLs to METHODS
	
	List<Car> vehicles = new ArrayList<>();
	
	// CRUD Functionality
	
	// CREATE
	@PostMapping("/create")
	public ResponseEntity<String> carCreate(@RequestBody Car c) {
		this.vehicles.add(c);
		return new ResponseEntity<>("Successfully added car", HttpStatus.CREATED);
		//return ResponseEntity.created(URI);
	}
	
	// READ
	
	// All
	@GetMapping("/read")
	public ResponseEntity<List<Car>> carReadAll(){
		return ResponseEntity.ok(this.vehicles);
	}
	
	// ByIndex
	@GetMapping("/read/{index}")
	public ResponseEntity<Car> carReadByIndex(@PathVariable int index) {
		return ResponseEntity.ok(this.vehicles.get(index));
	}
	
	// UPDATE - PUT (REPLACE) / PATCH (UPDATE an ELEMENT)
	@PatchMapping("/update/{index}")
	public ResponseEntity<Car> carUpdate(@PathVariable int index, @RequestBody Car newCar) {
		
//		Car toUpdate = this.vehicles.get(index);
//		toUpdate.setMake(newCar.getMake());
//		toUpdate.setModel(newCar.getModel());
//		toUpdate.setEngine(newCar.getEngine());
//		toUpdate.setSpoiler(newCar.isSpoiler());
//		return toUpdate;
		
		this.vehicles.set(index, newCar);
		return new ResponseEntity<>(this.vehicles.get(index), HttpStatus.ACCEPTED);
		
	}
	
	// DELETE - By Index
	@DeleteMapping("/delete/{index}")
	public ResponseEntity<Car> carDelete(@PathVariable int index) {
		
//		return new ResponseEntity<>(this.vehicles.remove(index), HttpStatus.NO_CONTENT);
		
		return this.vehicles.remove(index) != null ?
				new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
