package com.banking.users.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.banking.users.model.User;
import com.banking.users.poimpl.UserPOImpl;


public class UserUtility {

	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/mm/YYYY");
	
	public static UserPOImpl convertUserToUserPOImpl(User user) {
		UserPOImpl userPOImpl = new UserPOImpl();
		userPOImpl.setCin(user.getCin());
		userPOImpl.setUserName(user.getUserName());
		userPOImpl.setPassword(user.getPassword());
		userPOImpl.setFullName(user.getFullName());		
		userPOImpl.setDob(dateFormatter.format(user.getDob()));
		userPOImpl.setIsActive(user.getIsActive());		
		return userPOImpl;
	}
	
	public static Date convertStrignToDate(String date) {
		try {
			if(date==null ||"".equalsIgnoreCase(date))
				return Calendar.getInstance().getTime();
			return dateFormatter.parse(date);			
		}catch(Exception ex) {
			ex.printStackTrace();
			return Calendar.getInstance().getTime();
		}
	}
}
