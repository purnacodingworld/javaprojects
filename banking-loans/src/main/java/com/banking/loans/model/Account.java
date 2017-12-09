package com.banking.loans.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="accounts", schema="banking")
@Entity
public class Account {
	
	@Id
	@Column(name="acc_no", nullable=false, length=20)
	private String accNo;
		
	@ManyToOne(optional=false)
	@JoinColumn(name="acc_type_id")
	private AccountType accountType;	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="cin")
	private User user;	
		
	@Column(name="balance", nullable=true)
	private Double balance;

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}	
}
