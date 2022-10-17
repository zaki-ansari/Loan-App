package com.finzly.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentScheduleId;
	private LocalDate paymentDate;
	private Integer principal;
	private Double projectedInterest;
	private String paymentStatus;
	private Double paymentAmount;
	
	
	

}
