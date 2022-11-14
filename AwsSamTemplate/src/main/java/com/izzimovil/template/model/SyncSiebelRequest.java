package com.izzimovil.template.model;


public class SyncSiebelRequest {

	private String accountNumber;
	private String telephone;
	private String email;
	
	@Override
	public String toString() {
		return "SyncSiebelRequest [accountNumber=" + accountNumber + ", telephone=" + telephone + ", email=" + email
				+ "]";
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
