package com.learning.ListOfShips.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.ListOfShips.model.Ship;
import com.learning.ListOfShips.repository.ShipRepository;

@Controller
@RequestMapping(path = "API")
public class ShipsApiController {

	private ShipRepository shipRepository;
	
	@Autowired
	public ShipsApiController(ShipRepository shipRepository){
		this.shipRepository = shipRepository;
	}
	
	
	@GetMapping("ships")
	public @ResponseBody Iterable<Ship> getShips() {

		return shipRepository.findAll();
	}
	
	@GetMapping("ships/{id}")
	public @ResponseBody Optional<Ship> getShip(@PathVariable int id){
		return shipRepository.findById(id);
	}
}
