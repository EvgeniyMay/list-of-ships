package com.learning.ListOfShips.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.ListOfShips.model.Ship;
import com.learning.ListOfShips.repository.ShipRepository;

@RestController
@RequestMapping(path = "API")
public class ShipsApiController {

	private ShipRepository shipRepository;
	
	@Autowired
	public ShipsApiController(ShipRepository shipRepository){
		this.shipRepository = shipRepository;
	}
	
	
	@GetMapping("ships")
	public Iterable<Ship> getShips() {

		return shipRepository.findAll();
	}
	
	@GetMapping("ships/{id}")
	public Optional<Ship> getShip(@PathVariable int id){
		return shipRepository.findById(id);
	}
}
