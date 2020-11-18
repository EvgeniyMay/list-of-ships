package com.learning.ListOfShips.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ships")
public class Ship {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="class")
	private String className;
	
	@Column(name="faction")
	private String faction;
	
	@Column(name="classification")
	private String classification;
	
	
	public Ship() {
		
	}
	
	
	@Override
	public String toString() {
		return "Ship [id=" + id + ", name=" + name + ", shipClass=" + className + ", faction=" + faction
				+ ", classification=" + classification + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String shipClass) {
		this.className = shipClass;
	}
	
	public String getFaction() {
		return faction;
	}
	public void setFaction(String faction) {
		this.faction = faction;
	}
	
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
}
