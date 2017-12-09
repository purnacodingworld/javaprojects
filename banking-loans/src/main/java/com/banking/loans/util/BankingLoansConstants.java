package com.banking.loans.util;

import java.util.HashMap;
import java.util.Map;

public class BankingLoansConstants{
	
	//private static BankingLoansConstants bankingLoansConstants = null;
	private static Map<String,String> msgs = null;	
	//private static Object monitor = new Object();
	private static void init(){
		msgs = new HashMap<String,String>();
		msgs.put("LOAN_CLOSE_FAILD","Couldn't close your Loan account to some technical issue, please try again later or contact customer care.");
		msgs.put("LOAN_CLOSE_SUCCESS","Loan close transaction is completed successfully.");
	}
	
	/*public static BankingLoansConstants getInstance(){
		if(bankingLoansConstants==null){
			synchronized(monitor){
				bankingLoansConstants = new BankingLoansConstants();
			}
		}
		return bankingLoansConstants;
	}*/
	public static String getCodeMessage(String code){
		if(msgs==null)
			init();
		String message = "";
		if(msgs.containsKey(code)){
			message = msgs.get(code);
		}
		return message;
	}
}