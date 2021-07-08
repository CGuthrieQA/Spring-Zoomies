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
import com.qa.springcars.service.CarServiceDB;

@RestController
@RequestMapping("/cars") // http://127.0.0.1:8080/cars...
public class CarController {

	// Mapping URLs to METHODS

	private CarServiceDB service;

	// pull down object from the beanbag
	@Autowired
	public CarController(CarServiceDB service) {
		this.service = service;
	}

	// CRUD Functionality

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Car c) {
		return new ResponseEntity<>(this.service.create(c), HttpStatus.CREATED);
	}

	// READ
	@GetMapping("/read")
	public ResponseEntity<List<Car>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	// UPDATE - PUT (REPLACE) / PATCH (UPDATE an ELEMENT)
	@PatchMapping("/update/{index}")
	public ResponseEntity<Car> update(@PathVariable Long index, @RequestBody Car newCar) {
		return new ResponseEntity<>(this.service.update(index, newCar), HttpStatus.ACCEPTED);
	}

	// DELETE - By Index
	@DeleteMapping("/delete/{index}")
	public ResponseEntity<Car> delete(@PathVariable Long index) {
		return this.service.delete(index) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
