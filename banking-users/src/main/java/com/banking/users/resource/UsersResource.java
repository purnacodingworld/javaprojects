package com.banking.users.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banking.loans.util.ResponseContent;
import com.banking.loans.util.TxnRefGenerator;
import com.banking.users.poimpl.UserLoginPOImpl;
import com.banking.users.poimpl.UserPOImpl;
import com.banking.users.repository.service.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/users")
public class UsersResource {

	@Autowired
	private UserRepositoryService userRepoService;
	
	@PostMapping(path="/auth",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object authUser(@RequestBody UserLoginPOImpl loginDetails){
		try{
			return userRepoService.authUser(loginDetails);
		}catch(Exception ex){
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			return new ResponseContent(txnRefGenerator.generateTxnRef(),ex);						
		}		
	}
	
	@PostMapping(path="/register",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent createUser(@RequestBody UserPOImpl userPOImpl){
		try{
			return userRepoService.createUser(userPOImpl);
		}catch(Exception ex){
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			return new ResponseContent(txnRefGenerator.generateTxnRef(),ex);
		}		
	}
	
	@PutMapping(path="/update",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent updateUser(@RequestBody UserPOImpl userPOImpl){
		try{
			return userRepoService.updateUser(userPOImpl);
		}catch(Exception ex){
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			return new ResponseContent(txnRefGenerator.generateTxnRef(),ex);
		}		
	}
		
	@DeleteMapping(path="/delete",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent deleteUser(@RequestBody UserPOImpl userPOImpl){
		try{
			return userRepoService.deleteUser(userPOImpl);
		}catch(Exception ex){
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			return new ResponseContent(txnRefGenerator.generateTxnRef(),ex);						
		}			
	}
	
	@PostMapping(path="/deactivate",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent deactivateUser(@RequestBody UserPOImpl userPOImpl) {
		try{
			return userRepoService.deactivateUser(userPOImpl);
		}catch(Exception ex){
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			return new ResponseContent(txnRefGenerator.generateTxnRef(),ex);						
		}		
	}
	
	@PostMapping(path="/activate",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent activateUser(@RequestBody UserPOImpl userPOImpl) {
		try{
			return userRepoService.activateUser(userPOImpl);
		}catch(Exception ex){
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			return new ResponseContent(txnRefGenerator.generateTxnRef(),ex);						
		}		
	}
}
