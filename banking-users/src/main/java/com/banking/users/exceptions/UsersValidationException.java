package com.banking.users.exceptions;

public class UsersValidationException extends Exception{

	/**
	 * Banking Users Webservice inputs specific validation exception
	 */
	private static final long serialVersionUID = 1L;

	public UsersValidationException(String errorMsg){
		super(errorMsg);
	}
}
