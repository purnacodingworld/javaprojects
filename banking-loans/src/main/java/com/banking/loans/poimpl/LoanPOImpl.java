package com.banking.loans.poimpl;

import java.math.BigDecimal;

public class LoanPOImpl {

	private String loanNo;
	private String loanDesc;
	private BigDecimal dueAmount;
	private String isClosed;
	private String customerCin;
	private String customeFullName;
	private String dateOfBirth; 
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
	public String getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	public String getCustomerCin() {
		return customerCin;
	}
	public void setCustomerCin(String customerCin) {
		this.customerCin = customerCin;
	}
	public String getCustomeFullName() {
		return customeFullName;
	}
	public void setCustomeFullName(String customeFullName) {
		this.customeFullName = customeFullName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}	
}
