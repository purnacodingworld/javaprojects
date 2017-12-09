package com.banking.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banking.loans.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, String>{
	
}
