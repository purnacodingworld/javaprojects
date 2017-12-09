package com.banking.loans.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name="loans", schema="banking")
@Entity
public class Loan {
	
	@Id
	@Column(name="loan_no",nullable=false)	
	private String loanNo;
	
	@Column(name="loan_desc",nullable=false)
	private String loanDesc;
		
	@Column(name="start_date",nullable=false)
	private Date startDate;
	
	@Column(name="due_amount")
	private BigDecimal dueAmount;	

	@Column(name="is_closed", nullable=false,length=1)
	private String isClosed;		
		
	@ManyToOne(optional=false)
	@JoinColumn(name="acc_no")
	private Account account;
	
	public void setAccount(Account account){
		this.account = account;
	}
	
	public Account getAccount(){
		return account;
	}
	
	public String isClosed() {
		return isClosed;
	}

	public void setClosed(String isClosed) {
		this.isClosed = isClosed;
	}

	public String getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	public String getLoanDesc() {
		return loanDesc;
	}

	public void setLoanDesc(String loanDesc) {
		this.loanDesc = loanDesc;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(BigDecimal dueAmount) {
		this.dueAmount = dueAmount;
	}	
}
