package com.qa.springcars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.qa.springcars.service.CarServiceList;

@RestController
@RequestMapping("/cars") // http://127.0.0.1:8080/cars...
public class CarController {
	
	// Mapping URLs to METHODS
	
	private CarServiceList service;
	
	// pull down object from the beanbag
	@Autowired
	public CarController(CarServiceList service) {
		this.service = service;
	}
	
	// CRUD Functionality
	
	// CREATE
	@PostMapping("/create")
	public ResponseEntity<String> carCreate(@RequestBody Car c) {
		return new ResponseEntity<>(this.service.carCreate(c), HttpStatus.CREATED);
	}
	
	// READ
	@GetMapping("/read")
	public ResponseEntity<List<Car>> carReadAll(){
		return ResponseEntity.ok(this.service.carReadAll());	
	}
	
	// UPDATE - PUT (REPLACE) / PATCH (UPDATE an ELEMENT)
	@PatchMapping("/update/{index}")
	public ResponseEntity<Car> carUpdate(@PathVariable int index, @RequestBody Car newCar) {
		this.service.carUpdate(index, newCar);
		return new ResponseEntity<>(newCar, HttpStatus.ACCEPTED);
	}
	
	// DELETE - By Index
	@DeleteMapping("/delete/{index}")
	public ResponseEntity<Car> carDelete(@PathVariable int index) {
		return this.service.carDelete(index) ?
			new ResponseEntity<>(HttpStatus.NO_CONTENT)
			: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
