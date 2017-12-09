package com.banking.loans.util;

import com.banking.loans.model.Loan;
import com.banking.loans.poimpl.LoanPOImpl;

public class LoanUtility {

	public static LoanPOImpl convertLoanToLoanPOImpl(Loan loan) {
		LoanPOImpl loanImpl = new LoanPOImpl();
		loanImpl.setLoanNo(loan.getLoanNo());
		loanImpl.setLoanDesc(loan.getLoanDesc());
		loanImpl.setDueAmount(loan.getDueAmount());
		loanImpl.setClosed(loan.isClosed());		
		loanImpl.setAccountNo(loan.getAccount().getAccNo());
		return loanImpl;
	}

}
