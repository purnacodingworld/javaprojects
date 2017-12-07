package com.banking.loans.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.loans.model.Loan;
import java.util.List;
import com.banking.loans.repository.LoanRepository;
import com.banking.loans.util.ResponseContent;
import com.banking.loans.util.TxnRefGenerator;

@Service
public class LoanRepositoryService {

	@Autowired
	private LoanRepository loanRepository;			
	
	//Loan operation by loanNo
	public Loan getLoan(String loanNo){
		return loanRepository.findOne(loanNo);
	}
	
	public ResponseContent saveLoan(Loan loan){
		TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef(),"","");
		if(loanRepository.save(loan)==null){
			responseContent.setResponseCode("FAILD");
			responseContent.setResponseDesc("Unsuccessful");
		}else{
			responseContent.setResponseCode("SUCCUSS");
			responseContent.setResponseDesc("Successful");
		}
		return responseContent;
	}
	
	public ResponseContent deleteLoan(String loanNo){
		loanRepository.delete(loanNo);
		TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef(),"SUCCUSS","Successful");					
		return responseContent;
	}
	public ResponseContent closeLoan(String loanNo){
		Loan loan = getLoan(loanNo);	
		TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef(),"SUCCUSS","Successful");
		if(loanRepository.save(loan)==null)	{
			responseContent.setResponseCode("FAILD");
			responseContent.setResponseDesc("Unsuccessful");
		}			
		return responseContent;
	}
}
