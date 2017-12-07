package com.banking.loans.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="users", schema="banking")
@Entity
public class User {

	@Id
	private String cin;
		
	@Column(name="full_name", nullable=false)
	private String fullName;		
		
	@Column(name="dob", nullable=true)
	private Date dob;

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
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
}
