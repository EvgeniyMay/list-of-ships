package com.learning.ListOfShips.repository;

import org.springframework.data.repository.CrudRepository;

import com.learning.ListOfShips.model.Ship;

public interface ShipRepository extends CrudRepository<Ship, Integer>{

}
