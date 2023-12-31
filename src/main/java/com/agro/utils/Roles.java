package com.agro.utils;

public enum Roles {

	
	 ADMIN("Admin"), FARMER("Farmer"), BUYER("Buyer");
	
	
	private String value;
	
	public String getValue() {
		return value;
	}

	Roles(String value){
		this.value  = value;
	}
	

}
