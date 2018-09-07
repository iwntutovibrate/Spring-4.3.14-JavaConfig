package com.example.javaconfig.main.dto;

public class UserDTO {

	private String NAME = null;
	private Integer AGE = null;
	private String COUNTRY = null;

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public Integer getAGE() {
		return AGE;
	}

	public void setAGE(Integer aGE) {
		AGE = aGE;
	}

	public String getCOUNTRY() {
		return COUNTRY;
	}

	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}

	@Override
	public String toString() {
		return "UserDTO [NAME=" + NAME + ", AGE=" + AGE + ", COUNTRY=" + COUNTRY + "]";
	}

}
