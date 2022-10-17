package com.finzly.service;

import java.util.List;

import com.finzly.entity.Loan;
import com.finzly.payload.LoanDto;

public interface LoanService {
	
	public Loan saveLoan(LoanDto loanDto);
	
	public List<Loan> getAllLoan();

}
