package com.banking.loans.poimpl;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanPOImpl {

	@JsonProperty(value="Loan Number")
	private String loanNo;
	
	@JsonProperty(value="Loan Description")
	private String loanDesc;
	
	@JsonProperty(value="Loan Due Amount")
	private BigDecimal dueAmount;
	
	@JsonProperty(value="Loan Closed")
	private String isClosed;
		
	@JsonIgnore
	private String accountNo;
	
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
	public BigDecimal getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(BigDecimal dueAmount) {
		this.dueAmount = dueAmount;
	}
	public String isClosed() {
		return isClosed;
	}
	public void setClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}	
}
