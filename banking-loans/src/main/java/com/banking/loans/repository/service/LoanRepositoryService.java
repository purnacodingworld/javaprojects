package com.banking.loans.repository.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.loans.exceptions.LoansValidationException;
import com.banking.loans.model.Account;
import com.banking.loans.model.Loan;
import com.banking.loans.poimpl.LoanPOImpl;
import com.banking.loans.repository.LoanRepository;
import com.banking.loans.util.LoanUtility;
import com.banking.loans.util.ResponseContent;
import com.banking.loans.util.TxnRefGenerator;

@Service
public class LoanRepositoryService {

	@Autowired
	private LoanRepository loanRepository;			
	
	//Loan operation by loanNo
	public LoanPOImpl getLoan(String loanNo)throws LoansValidationException{
		if(loanNo==null || "".equalsIgnoreCase(loanNo))
			throw new LoansValidationException("Loan Number value is null or empty.");
		Loan loan = loanRepository.findOne(loanNo);
		if(loan==null)
			throw new LoansValidationException("Loan Number value is not existed in our records.");
		return LoanUtility.convertLoanToLoanPOImpl(loan);		
	}
	
	public ResponseContent saveLoan(LoanPOImpl loanPOImpl)throws LoansValidationException{		
		if(loanPOImpl==null || loanPOImpl.getLoanNo()==null || "".equalsIgnoreCase(loanPOImpl.getLoanNo()))
			throw new LoansValidationException("Loan Number value is null or empty.");
		Loan loan = loanRepository.findOne(loanPOImpl.getLoanNo());
		if(loan==null){
			Loan newLoan = new Loan();
			newLoan.setLoanNo(loanPOImpl.getLoanNo());
			newLoan.setLoanDesc(loanPOImpl.getLoanDesc());
			newLoan.setStartDate(new Date());
			newLoan.setDueAmount(loanPOImpl.getDueAmount());
			newLoan.setClosed(loanPOImpl.isClosed());
			//Need to access Accoutns webservice to get Account information
			Account account = null;
			if(account==null)
				throw new LoansValidationException("Loan could not be created as mapped account number is not existed.");
			newLoan.setAccount(account);
			
			TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
			ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef());
			if(loanRepository.save(newLoan)==null)
				responseContent.setResponseCode("LOAN_SAVE_FAILD");
			else
				responseContent.setResponseCode("LOAN_SAVE_SUCCESS");
			return responseContent;
		}else{
			throw new LoansValidationException("Loan Number value is already existed.");
		}		
	}
	
	public ResponseContent updateLoan(LoanPOImpl loanPOImpl)throws LoansValidationException{		
		if(loanPOImpl==null || loanPOImpl.getLoanNo()==null || "".equalsIgnoreCase(loanPOImpl.getLoanNo()))
			throw new LoansValidationException("Loan Number value is null or empty.");
		Loan loan = loanRepository.findOne(loanPOImpl.getLoanNo());
		if(loan==null)
			throw new LoansValidationException("Loan Number value is not existed in our records.");					
		loan.setLoanDesc(loanPOImpl.getLoanDesc());
		loan.setDueAmount(loanPOImpl.getDueAmount());
		loan.setClosed(loanPOImpl.isClosed());
		TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef());
		if(loanRepository.save(loan)==null)	{
			throw new LoansValidationException("Loan Number value is not existed in our records.");			
		}else{
			responseContent.setResponseCode("LOAN_CLOSE_SUCCESS");
		}		
		return responseContent;		
	}
	
	public ResponseContent deleteLoan(String loanNo)throws LoansValidationException{
		if(loanNo==null || "".equalsIgnoreCase(loanNo))
			throw new LoansValidationException("Loan Number value is null or empty.");
		loanRepository.delete(loanNo);					
		TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef());
		responseContent.setResponseCode("LOAN_CLOSE_SUCCESS");
		return responseContent;
	}
	public ResponseContent closeLoan(String loanNo)throws LoansValidationException{
		if(loanNo==null || "".equalsIgnoreCase(loanNo))
			throw new LoansValidationException("Loan Number value is null or empty.");		
		Loan loan = loanRepository.findOne(loanNo);	
		if(loan==null)
			throw new LoansValidationException("Loan Number value is not existed in our records.");	
		loan.setClosed("Y");
		TxnRefGenerator txnRefGenerator = TxnRefGenerator.getInstance();				
		ResponseContent responseContent = new ResponseContent(txnRefGenerator.generateTxnRef());
		if(loanRepository.save(loan)==null)	{
			responseContent.setResponseCode("LOAN_CLOSE_FAILD");			
		}else{
			responseContent.setResponseCode("LOAN_CLOSE_SUCCESS");
		}
		return responseContent;
	}
}
