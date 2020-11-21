package com.learning.ListOfShips.controller;

import java.util.Optional;

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
@RequestMapping(path = "ships")
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
	
	@PostMapping("add")
	public String addShip(
			@RequestParam(name="name")String name,
			@RequestParam(name="className")String className,
			@RequestParam(name="faction")String faction,
			@RequestParam(name="classification")String classification) {
		Ship ship = new Ship();
		ship.setName(name);
		ship.setClassName(className);
		ship.setFaction(faction);
		ship.setClassification(classification);
		
		shipRepository.save(ship);
		
		return "redirect:list";
	}
	
	@GetMapping("edit/{id}")
	public String getEditShipPage(@PathVariable("id")int id, Model model) {
		Optional<Ship> optionalShip = shipRepository.findById(id);
		
		if(!optionalShip.isPresent()) {
			return "redirect:/ships/list";
		}
		
		Ship ship = optionalShip.get();
		
		model.addAttribute("name", ship.getName());
		model.addAttribute("className", ship.getClassName());
		model.addAttribute("faction", ship.getFaction());
		model.addAttribute("classification", ship.getClassification());
		
		return "ships/edit";
	}
	
	@PostMapping("edit/{id}")
	public String saveEditShip(@PathVariable("id")int id,
			@RequestParam(name="name")String name,
			@RequestParam(name="className")String className,
			@RequestParam(name="faction")String faction,
			@RequestParam(name="classification")String classification) {
	
		Ship shipToChange = shipRepository.findById(id).get();
	
		shipToChange.setName(name);
		shipToChange.setClassName(className);
		shipToChange.setFaction(faction);
		shipToChange.setClassification(classification);
		
		shipRepository.save(shipToChange);
		
		return "redirect:/ships/list";
	}
	
	@GetMapping("delete/{id}")
	public String deleteShip(@PathVariable("id")int id) {
		
		shipRepository.deleteById(id);
		
		return "redirect:/ships/list";
	}
	
}
