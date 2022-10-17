package com.finzly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.entity.Loan;
import com.finzly.payload.LoanDto;
import com.finzly.service.LoanService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@PostMapping("/save")
	ResponseEntity<Loan> saveLoan(@RequestBody LoanDto loanDto){
		
		Loan savedLoan = this.loanService.saveLoan(loanDto);
		return new ResponseEntity<Loan>(savedLoan,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	ResponseEntity<List<Loan>> getAllEmployees(){
		List<Loan> allLoan = this.loanService.getAllLoan();
		return new ResponseEntity<List<Loan>>(allLoan,HttpStatus.CREATED);
	}
	

}
