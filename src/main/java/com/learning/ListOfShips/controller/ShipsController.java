package com.learning.ListOfShips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	@GetMapping()
	public String getAllShips(Model model) {
		model.addAttribute("ships", shipRepository.findAll());
		
		return "ships";
	}
	
	@GetMapping("/add")
	public String GetAddNewShip() {
		
		return "addShip";
	}
	@PostMapping("/add")
	public String PostAddNewShip(
			@RequestParam(name="name")String name,
			@RequestParam(name="className")String className,
			@RequestParam(name="faction")String faction,
			@RequestParam(name="classification")String classification,
			@RequestParam(name="imgLink")String imgLink) {
		Ship ship = new Ship();
		ship.setName(name);
		ship.setClassName(className);
		ship.setFaction(faction);
		ship.setClassification(classification);
		ship.setImgLink(imgLink);
		
		shipRepository.save(ship);
		
		return "redirect:/ships";
	}
	
}
