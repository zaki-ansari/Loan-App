package com.finzly.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.entity.Loan;
import com.finzly.entity.PaymentSchedule;
import com.finzly.exception.ResourceNotFoundException;
import com.finzly.payload.LoanDto;
import com.finzly.payload.PaymentFrequency;
import com.finzly.payload.PaymentStatus;
import com.finzly.repository.LoanRepo;
import com.finzly.repository.PaymentScheduleRepo;
import com.finzly.service.PaymentScheduleService;


@Service
public class PaymentScheduleServiceImpl implements PaymentScheduleService{
	
	
	
	@Autowired
	private PaymentScheduleRepo paymentScheduleRepo;
	
	@Autowired
	private LoanRepo loanRepo;

	public static final int Start_Days=10;
	
	@Override
	public List<PaymentSchedule> createPaymentSchedules(LoanDto loanDto) {
		
		if(loanDto.getPaymentTerm().equals("Even Principal")) {
			List<PaymentSchedule> schedules = this.EvenPrincipalPayment(loanDto);
			
			return schedules;
		}
		else {
			List<PaymentSchedule> schedules = this.InterestOnlyPayment(loanDto);
			return schedules;
		}
		
		
	}
	
	@Override
	public List<PaymentSchedule> getAllPaymentSchedules() {
		List<PaymentSchedule> schedules = this.paymentScheduleRepo.findAll();
		return schedules;
	}
	
	@Override
	public List<PaymentSchedule> getParticularSchedules(Integer Id) {
		Loan loan = this.loanRepo.findById(Id).get();
		List<PaymentSchedule> schedules = loan.getPaymentSchedule();
		return schedules;
	}
	

	public List<PaymentSchedule> InterestOnlyPayment(LoanDto loanDto) {
		
		Integer paymentFrequency = PaymentFrequency.valueOf(loanDto.getPaymentFrequency().toUpperCase()).getValue();
		int numberOfPayments=(loanDto.getLoanTerm()*12)/paymentFrequency;
		int principal = loanDto.getLoanAmount();
		LocalDate paymentDate = LocalDate.now().plusDays(Start_Days);
		List<PaymentSchedule> schedules = new ArrayList<PaymentSchedule>();
		int time = loanDto.getLoanTerm();
		
		for(int i=1;i<=numberOfPayments;i++) {
			
			PaymentSchedule paymentSchedule = new PaymentSchedule();
			Double projectedInterest = (principal*loanDto.getInterestRate()*paymentFrequency/12)*0.01;
			paymentSchedule.setPaymentDate(paymentDate.plusMonths(paymentFrequency));
			
			paymentSchedule.setProjectedInterest((double)Math.round(projectedInterest));
			
			paymentSchedule.setPaymentStatus(PaymentStatus.PROJECTED.toString());	
//			System.out.println(paymentSchedule.getPaymentDate()+"====="+LocalDate.now().plusDays(10).plusYears(loanDto.getLoanTerm()));
//			System.out.println(paymentSchedule.getPaymentDate().compareTo(LocalDate.now().plusDays(10).plusYears(loanDto.getLoanTerm()))==0);
			if(paymentSchedule.getPaymentDate().compareTo(LocalDate.now().plusDays(Start_Days).plusYears(loanDto.getLoanTerm()))==0){
//				paymentSchedule.setPaymentStatus(PaymentStatus.AWAITINGPAYMENT.toString());
				paymentSchedule.setPaymentAmount((double)Math.round(loanDto.getLoanAmount()+projectedInterest));
				paymentSchedule.setPrincipal(principal);
			}else {
				paymentSchedule.setPaymentAmount((double)Math.round(projectedInterest));
				paymentSchedule.setPrincipal(0);
			}
			schedules.add(paymentSchedule);
//			this.paymentScheduleRepo.save(paymentSchedule);
			paymentDate=paymentDate.plusMonths(paymentFrequency);
//			time=time-(paymentFrequency/12);
		}
		return schedules;
		
	}
	
	
public List<PaymentSchedule> EvenPrincipalPayment(LoanDto loanDto) {
		
		Integer paymentFrequency = PaymentFrequency.valueOf(loanDto.getPaymentFrequency().toUpperCase()).getValue();
		int numberOfPayments=(loanDto.getLoanTerm()*12)/paymentFrequency;
		int principal = loanDto.getLoanAmount();
		int p = loanDto.getLoanAmount()/numberOfPayments;
		//System.out.println(principal);
		LocalDate paymentDate = LocalDate.now().plusDays(Start_Days);
		List<PaymentSchedule> schedules = new LinkedList<PaymentSchedule>();
		int time = loanDto.getLoanTerm();
		  
		for(int i=1;i<=numberOfPayments;i++) {
			PaymentSchedule paymentSchedule = new PaymentSchedule();
			Double projectedInterest = (principal*loanDto.getInterestRate()*paymentFrequency/12)*0.01;
			paymentSchedule.setPaymentDate(paymentDate.plusMonths(paymentFrequency));
			paymentSchedule.setPaymentAmount((double)Math.round(p+projectedInterest));
			paymentSchedule.setProjectedInterest((double)Math.round(projectedInterest));
			paymentSchedule.setPrincipal(principal);
			System.out.println(paymentSchedule.getPrincipal());
			paymentSchedule.setPaymentStatus(PaymentStatus.PROJECTED.toString());
			
			schedules.add(paymentSchedule);
//			this.paymentScheduleRepo.save(paymentSchedule);
			
			principal=principal-(loanDto.getLoanAmount()/numberOfPayments);
			paymentDate=paymentDate.plusMonths(paymentFrequency);
//			time=time-(paymentFrequency/12);
		}
		return schedules;
		
	}
	

@Override
public PaymentSchedule updatePaymentScheduleStatus(PaymentSchedule paymentSchedule) throws ResourceNotFoundException{
	
//	PaymentSchedule paymentSchedule = new PaymentSchedule();
//	paymentSchedule.setPaymentScheduleId(paymentScheduleObj.getPaymentScheduleId());
	
	PaymentSchedule paymentSchedule2 = this.paymentScheduleRepo.findById(paymentSchedule.getPaymentScheduleId()).get();
	
	paymentSchedule2.setPaymentStatus(PaymentStatus.PAID.toString());
	PaymentSchedule savedPaymentSchedule = this.paymentScheduleRepo.save(paymentSchedule2);
	return savedPaymentSchedule;
}


@Override
public PaymentSchedule updatePaymentScheduleStatusToAwaiting(PaymentSchedule paymentSchedule) throws ResourceNotFoundException{

	PaymentSchedule paymentSchedule2 = this.paymentScheduleRepo.findById(paymentSchedule.getPaymentScheduleId()).get();
	
	paymentSchedule2.setPaymentStatus(PaymentStatus.AWAITINGPAYMENT.toString());
	PaymentSchedule savedPaymentSchedule = this.paymentScheduleRepo.save(paymentSchedule2);
	return savedPaymentSchedule;
}





}
