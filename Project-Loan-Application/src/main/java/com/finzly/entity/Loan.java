package com.finzly.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private Integer loanAmount;
	@CreationTimestamp
	private LocalDate tradeDate;
	private LocalDate loanStartDate;
	private LocalDate maturityDate;
	private Integer paymentFrequency;
	private Double interestRate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="paymentSchedule_fk",referencedColumnName = "customerId")
	private List<PaymentSchedule> paymentSchedule;
	
	
}
