package com.learning.ListOfShips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.ListOfShips.model.Ship;
import com.learning.ListOfShips.repository.ShipRepository;

@Controller
@RequestMapping(path = "/ships")
public class ShipsController {
	
	private ShipRepository shipRepository;
	
	@Autowired
	public ShipsController(ShipRepository shipRepository) {
		this.shipRepository = shipRepository;
	}
	
	
	@GetMapping("list")
	public String getAllShips(Model model) {
		model.addAttribute("ships", shipRepository.findAll());
		
		return "ships/shipsList";
	}
	
	@GetMapping("/add")
	public String addShipPage() {
		
		return "ships/addShip";
	}
	@PostMapping("/add")
	public String addShip(
			@RequestParam(name="name")String name,
			@RequestParam(name="className")String className,
			@RequestParam(name="faction")String faction,
			@RequestParam(name="classification")String classification){
		Ship ship = new Ship();
		ship.setName(name);
		ship.setClassName(className);
		ship.setFaction(faction);
		ship.setClassification(classification);
		
		shipRepository.save(ship);
		
		return "redirect:list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteShip(
			@PathVariable("id")int id) {
		
		shipRepository.deleteById(id);
		
		return "redirect:/ships/list";
	}
	
}
