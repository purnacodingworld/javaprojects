package com.banking.loans.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.loans.exceptions.LoansValidationException;
import com.banking.loans.model.Loan;
import com.banking.loans.poimpl.LoanPOImpl;
import com.banking.loans.repository.service.LoanRepositoryService;
import com.banking.loans.util.LoanUtility;
import com.banking.loans.util.ResponseContent;
import com.banking.loans.util.TxnRefGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/loans")
public class LoansResource {

	@Autowired
	private LoanRepositoryService loanRepoService;
	
	@GetMapping(path="/get/{loanno}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getLoan(@PathVariable("loanno") String loanNo){
		try{
			return loanRepoService.getLoan(loanNo);
		}catch(Exception ex){
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			return new ResponseContent(txnRefGenerator.generateTxnRef(),ex);						
		}		
	}
	
	@PutMapping(path="/save",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent saveLoan(@RequestBody LoanPOImpl loanPOImpl){
		try{
			return loanRepoService.saveLoan(loanPOImpl);
		}catch(Exception ex){
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			return new ResponseContent(txnRefGenerator.generateTxnRef(),ex);
		}		
	}
	
	@PostMapping(path="/update",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent updateLoan(@RequestBody LoanPOImpl loanPOImpl){
		try{
			return loanRepoService.updateLoan(loanPOImpl);
		}catch(Exception ex){
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			return new ResponseContent(txnRefGenerator.generateTxnRef(),ex);
		}		
	}
		
	@DeleteMapping(path="/delete/{loanno}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent removeLoan(@PathVariable("loanno") String loanNo){
		try{
			return loanRepoService.deleteLoan(loanNo);
		}catch(Exception ex){
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			return new ResponseContent(txnRefGenerator.generateTxnRef(),ex);						
		}			
	}
	
	@GetMapping(path="/close/{loanno}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent closeLoan(@PathVariable("loanno") String loanNo){
		try{
			return loanRepoService.closeLoan(loanNo);
		}catch(Exception ex){
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			return new ResponseContent(txnRefGenerator.generateTxnRef(),ex);						
		}		
	}
}
