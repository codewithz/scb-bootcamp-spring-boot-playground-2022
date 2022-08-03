package com.scb.rpg.springplayground.entities.vo;

import java.time.LocalDate;

public class CustomerSchemeVO {

	private String customerName;
	private String email;
	private String accountType;
	private String schemeName;
	private String schemeDescription;
	private LocalDate dateApplied;
	private String status;
	
	public CustomerSchemeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerSchemeVO(String customerName, String email, String accountType, String schemeName,
			String schemeDescription, LocalDate dateApplied, String status) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.accountType = accountType;
		this.schemeName = schemeName;
		this.schemeDescription = schemeDescription;
		this.dateApplied = dateApplied;
		this.status = status;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeDescription() {
		return schemeDescription;
	}

	public void setSchemeDescription(String schemeDescription) {
		this.schemeDescription = schemeDescription;
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
		return "CustomerSchemeVO [customerName=" + customerName + ", email=" + email + ", accountType=" + accountType
				+ ", schemeName=" + schemeName + ", schemeDescription=" + schemeDescription + ", dateApplied="
				+ dateApplied + ", status=" + status + "]";
	}
	
	
	
	
}
