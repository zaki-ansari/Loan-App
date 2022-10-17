package com.finzly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finzly.entity.Loan;

public interface LoanRepo extends JpaRepository<Loan, Integer> {

}
