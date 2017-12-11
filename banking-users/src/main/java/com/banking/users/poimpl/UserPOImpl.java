package com.banking.users.poimpl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPOImpl {

	@JsonProperty(value="customer cin",required=true)
	private Long cin;
	
	@JsonProperty(value="user name",required=true)
	private String userName;
	
	@JsonProperty(value="password",required=true)
	@JsonIgnore
	private String password;
	
	@JsonProperty(value="full name")
	private String fullName;
	
	@JsonProperty(value="date of birth")
	private String dob;
	
	@JsonProperty(value="user active")
	private String isActive;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Long getCin() {
		return cin;
	}

	public void setCin(Long cin) {
		this.cin = cin;
	}
	
}
