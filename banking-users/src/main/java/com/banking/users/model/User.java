package com.banking.users.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Table(name="users")
@Entity
//@IdClass(value = UserId.class)
public class User {
		
	@Id
	@Column(name="user_name",nullable=false,length=12)
	private String userName;
	
	//@Id
	@Column(name="cin",length=9)
	private String cin;
	
	@Column(name="password",nullable=false,length=15)
	private String password;
	
	@Column(name="full_name", nullable=false)
	private String fullName;		
		
	@Column(name="dob", nullable=true)
	private Date dob;

	@Column(name="is_active", nullable=false, length=1)
	private String isActive;

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userNmae) {
		this.userName = userNmae;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {		
		return "\nuser name:"+userName+"\ncin:"+cin+"\npassword:"+password+"\nfull name:"+fullName+"\ndob:"+dob+"\n isactive:"+isActive;
	}
}
