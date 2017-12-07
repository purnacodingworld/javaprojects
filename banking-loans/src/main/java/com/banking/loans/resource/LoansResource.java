package com.banking.loans.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banking.loans.model.Loan;
import com.banking.loans.repository.service.LoanRepositoryService;
import com.banking.loans.util.ResponseContent;
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
	public Loan getLoan(@PathVariable("loanno") String loanNo){
		return loanRepoService.getLoan(loanNo);
	}
	
	@PostMapping(path="/update",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent updateLoan(@RequestBody Loan loan){
		return loanRepoService.saveLoan(loan);
	}
	
	@PutMapping(path="/save",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent saveLoan(@RequestBody Loan loan){
		return loanRepoService.saveLoan(loan);
	}
	@DeleteMapping(path="/delete/{loanno}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent removeLoanByLoanNo(@PathVariable("loanno") String loanNo){
		return loanRepoService.deleteLoan(loanNo);
	}
	
	@GetMapping(path="/close/{loanno}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseContent closeAllLoansByAccNo(@PathVariable("loanno") String loanNo){
		return loanRepoService.closeLoan(loanNo);
	}
}
