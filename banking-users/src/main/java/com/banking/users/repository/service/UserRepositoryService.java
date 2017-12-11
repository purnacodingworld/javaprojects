package com.banking.users.repository.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.users.exceptions.UsersValidationException;
import com.banking.users.model.User;
import com.banking.users.poimpl.UserLoginPOImpl;
import com.banking.users.poimpl.UserPOImpl;
import com.banking.users.repository.UserRepository;
import com.banking.users.util.UserUtility;
import com.banking.loans.util.ResponseContent;
import com.banking.loans.util.TxnRefGenerator;

@Service
public class UserRepositoryService {

	@Autowired
	private UserRepository userRepository;			
	
	private TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
	
	//User operations by user Details
	public Object authUser(UserLoginPOImpl loginDetails)throws UsersValidationException{
		if(loginDetails==null || loginDetails.getUserName()==null || "".equalsIgnoreCase(loginDetails.getUserName()) 
				|| "".equalsIgnoreCase(loginDetails.getPassword()) || loginDetails.getPassword()==null)
			throw new UsersValidationException("User details are null or empty.");
		User user  = userRepository.findOneByUserName(loginDetails.getUserName());	
		if(user==null)
			throw new UsersValidationException("User is not existed in our records.");		
		
		String userPassword = loginDetails.getPassword();
		String dbPassword = user.getPassword();				
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef());
		if(userPassword.equals(dbPassword)) {
			responseContent.setResponseCode("USER_LOGIN_SUCCESS");
			return UserUtility.convertUserToUserPOImpl(user);
		}
		responseContent.setResponseCode("USER_LOGIN_FAILD");
		return responseContent;	
	}
	
	public ResponseContent createUser(UserPOImpl userPOImpl)throws UsersValidationException{
		String newUserName = userPOImpl.getUserName();
		String newPassword = userPOImpl.getPassword();
		String newFullName = userPOImpl.getFullName();		
		
		if(userPOImpl==null || newUserName==null || "".equalsIgnoreCase(newUserName) || newPassword==null 
				            || "".equalsIgnoreCase(newPassword) || newFullName==null || "".equalsIgnoreCase(newFullName))
			throw new UsersValidationException("User details are null or empty.");
		User user  = userRepository.findOneByUserName(newUserName);	
		if(user!=null)
			throw new UsersValidationException("User is already extisted.");		
		
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef());		
		
		user= new User();		
		user.setUserName(newUserName);
		user.setPassword(newPassword);
		user.setFullName(newFullName);
		user.setDob(UserUtility.convertStrignToDate(userPOImpl.getDob()));
		user.setIsActive(userPOImpl.getIsActive());
		System.out.println("new User Objetc:"+user);
		if(userRepository.save(user)==null)
			responseContent.setResponseCode("USER_CREATE_FAILD");		
		else
			responseContent.setResponseCode("USER_CREATE_SUCCESS");
		return responseContent;		
	}
	
	public ResponseContent updateUser(UserPOImpl userPOImpl)throws UsersValidationException{
		if(userPOImpl==null || userPOImpl.getCin()==null || "".equalsIgnoreCase(userPOImpl.getUserName()))
			throw new UsersValidationException("User details are null or empty.");
		User user  = userRepository.findOne(userPOImpl.getCin());	
		if(user==null)
			throw new UsersValidationException("User is not existed in our records.");		
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef());
		responseContent.setResponseCode("USER_UPDATE_SUCCESS");
		
		if(userPOImpl.getPassword()!=null && !"".equalsIgnoreCase(userPOImpl.getPassword()))
			user.setPassword(userPOImpl.getPassword());
		if(userPOImpl.getFullName()!=null && !"".equalsIgnoreCase(userPOImpl.getFullName()))
			user.setFullName(userPOImpl.getFullName());
		if(userPOImpl.getDob()!=null && !"".equalsIgnoreCase(userPOImpl.getDob())) 			
			user.setDob(new Date(userPOImpl.getDob()));	
		if(userPOImpl.getIsActive()!=null && !"".equalsIgnoreCase(userPOImpl.getIsActive()))
			user.setIsActive(userPOImpl.getIsActive());
		
		if(userRepository.save(user)==null)	
			responseContent.setResponseCode("USER_UPDATE_FAILD");
		return responseContent;		
	}
	
	public ResponseContent deleteUser(UserPOImpl userPOImpl)throws UsersValidationException{
		if(userPOImpl==null || userPOImpl.getCin()==null || "".equalsIgnoreCase(userPOImpl.getUserName()))
			throw new UsersValidationException("User details are null or empty.");
		User user  = userRepository.findOne(userPOImpl.getCin());	
		if(user==null)
			throw new UsersValidationException("User is not existed in our records.");	
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef());
		responseContent.setResponseCode("USER_DELETE_SUCCESS");
		userRepository.delete(user);
		return responseContent;
	}
	public ResponseContent deactivateUser(UserPOImpl userPOImpl)throws UsersValidationException{
		if(userPOImpl==null || userPOImpl.getCin()==null || "".equalsIgnoreCase(userPOImpl.getUserName()))
			throw new UsersValidationException("User details are null or empty.");
		User user  = userRepository.findOne(userPOImpl.getCin());	
		if(user==null)
			throw new UsersValidationException("User is not existed in our records.");			
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef());
		responseContent.setResponseCode("USER_DEACTIVE_SUCCESS");
		if("Y".equalsIgnoreCase(user.getIsActive())) {
			user.setIsActive("N");							
			if(userRepository.save(user)==null)	
				responseContent.setResponseCode("USER_DEACTIVE_FAILD");								
		}
		return responseContent;	
	}
	
	public ResponseContent activateUser(UserPOImpl userPOImpl)throws UsersValidationException{
		if(userPOImpl==null || userPOImpl.getCin()==null || "".equalsIgnoreCase(userPOImpl.getUserName()))
			throw new UsersValidationException("User details are null or empty.");
		User user  = userRepository.findOne(userPOImpl.getCin());	
		if(user==null)
			throw new UsersValidationException("User is not existed in our records.");			
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef());
		responseContent.setResponseCode("USER_ACTIVE_SUCCESS");
		if("N".equalsIgnoreCase(user.getIsActive())) {
			user.setIsActive("Y");							
			if(userRepository.save(user)==null)	
				responseContent.setResponseCode("USER_ACTIVE_FAILD");								
		}
		return responseContent;
	}
}
