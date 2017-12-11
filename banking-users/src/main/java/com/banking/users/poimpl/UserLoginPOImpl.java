package com.banking.users.poimpl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginPOImpl {

	@JsonProperty(value="username", required=true)
	private String userName;
	
	@JsonProperty(value="password", required=true)
	private String password;
	
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
	
}
