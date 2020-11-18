package com.learning.ListOfShips.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.ListOfShips.model.Ship;

@Repository
public interface ShipRepository extends CrudRepository<Ship, Integer>{

}
