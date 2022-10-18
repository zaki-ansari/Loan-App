package com.finzly.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
	
	private Integer customerId;
	private Integer loanAmount;
	private String paymentTerm;
	private Integer loanTerm;
	private String paymentFrequency;
	private Double interestRate;

}
