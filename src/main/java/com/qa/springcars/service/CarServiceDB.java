package com.qa.springcars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springcars.domain.Car;
import com.qa.springcars.repo.CarRepo;

@Service
public class CarServiceDB {
	
	// Dependency
	private CarRepo repo;
	
	@Autowired
	public CarServiceDB(CarRepo repo) {
		this.repo = repo;
	}
	
	// CRUD
	
	// CREATE
	public String create(Car c) {
		this.repo.saveAndFlush(c);
		return "Successfully added Car to repo!";
	}
	
	// READ
	public List<Car> readAll() {
		return this.repo.findAll();
	}
	
	// UPDATE
	public Car update(Long id, Car newCar) {
		Car toUpdate = this.repo.findById(id)
								.orElseThrow();
		toUpdate.setEngine(0);
		toUpdate.setMake(null);
		toUpdate.setModel(null);
		toUpdate.setSpoiler(false);
		// util merge not null in here
		// CarUtil.mergeNotNull(newCar, toUpdate);
		return this.repo.save(toUpdate);
	}
	
	// DELETE
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
