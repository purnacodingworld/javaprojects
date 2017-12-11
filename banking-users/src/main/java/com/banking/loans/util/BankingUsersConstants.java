package com.banking.loans.util;

import java.util.HashMap;
import java.util.Map;

public class BankingUsersConstants{
	
	//private static BankingLoansConstants bankingLoansConstants = null;
	private static Map<String,String> msgs = null;	
	//private static Object monitor = new Object();
	private static void init(){
		msgs = new HashMap<String,String>();
		msgs.put("USER_LOGIN_SUCCESS", "User login successful.");
		msgs.put("USER_LOGIN_FAILD", "User login faild.");
		msgs.put("USER_CREATE_SUCCESS", "User registration successful.");
		msgs.put("USER_CREATE_FAILD", "User registration faild.");
		msgs.put("USER_UPDATE_SUCCESS", "User update successful.");
		msgs.put("USER_UPDATE_FAILD", "User update faild.");
		msgs.put("USER_DELETE_SUCCESS", "User delete successful.");
		msgs.put("USER_DELETE_FAILD", "User delete faild.");		
		msgs.put("USER_DEACTIVE_SUCCESS", "User deactivate successful.");
		msgs.put("USER_DEACTIVE_FAILD", "User deactivate faild.");
		msgs.put("USER_ACTIVE_SUCCESS", "User activate successful.");
		msgs.put("USER_ACTIVE_FAILD", "User activate faild.");		
	}

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