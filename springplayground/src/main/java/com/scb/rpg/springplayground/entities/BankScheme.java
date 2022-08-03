package com.scb.rpg.springplayground.entities;

import java.time.LocalDate;

public class BankScheme {
	
	private int id;
	String name,description;
	LocalDate schemeCreationDate;
	
	public BankScheme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankScheme(String name, String description, LocalDate schemeCreationDate) {
		super();
		this.name = name;
		this.description = description;
		this.schemeCreationDate = schemeCreationDate;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getSchemeCreationDate() {
		return schemeCreationDate;
	}

	public void setSchemeCreationDate(LocalDate schemeCreationDate) {
		this.schemeCreationDate = schemeCreationDate;
	}

	@Override
	public String toString() {
		return "BankScheme [id=" + id + ", name=" + name + ", description=" + description + ", schemeCreationDate="
				+ schemeCreationDate + "]";
	}
	
	
	
	

}
