package com.banking.loans.exceptions;

public class LoansValidationException extends Exception{

	/**
	 * Banking Loans Webservice inputs specific validation exception
	 */
	private static final long serialVersionUID = 1L;

	public LoansValidationException(String errorMsg){
		super(errorMsg);
	}
}
