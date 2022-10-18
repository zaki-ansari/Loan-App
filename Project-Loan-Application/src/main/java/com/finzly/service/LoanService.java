package com.finzly.service;

import java.util.List;

import com.finzly.entity.Loan;
import com.finzly.exception.ResourceNotFoundException;
import com.finzly.payload.LoanDto;

public interface LoanService {
	
	public Loan saveLoan(LoanDto loanDto) throws ResourceNotFoundException;
	
	public List<Loan> getAllLoan();

}
