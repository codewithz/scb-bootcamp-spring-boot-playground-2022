package com.scb.rpg.springplayground.entities;

import java.time.LocalDate;

public class CustomerBankScheme {

	
	private int id;
	private int customerId;
	private int schemeId;
	private LocalDate dateApplied;
	private String status;
	
	
	public CustomerBankScheme() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerBankScheme(int customerId, int schemeId, LocalDate dateApplied, String status) {
		super();
		this.customerId = customerId;
		this.schemeId = schemeId;
		this.dateApplied = dateApplied;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getSchemeId() {
		return schemeId;
	}


	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}


	public LocalDate getDateApplied() {
		return dateApplied;
	}


	public void setDateApplied(LocalDate dateApplied) {
		this.dateApplied = dateApplied;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "CustomerBankScheme [id=" + id + ", customerId=" + customerId + ", schemeId=" + schemeId
				+ ", dateApplied=" + dateApplied + ", status=" + status + "]";
	}
	
	
	
	
}
