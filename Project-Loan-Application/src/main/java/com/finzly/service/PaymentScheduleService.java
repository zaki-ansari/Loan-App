package com.finzly.service;

import java.util.List;

import com.finzly.entity.PaymentSchedule;
import com.finzly.exception.ResourceNotFoundException;
import com.finzly.payload.LoanDto;

public interface PaymentScheduleService {
	
	public List<PaymentSchedule> createPaymentSchedules(LoanDto loanDto);
	
	public List<PaymentSchedule> getAllPaymentSchedules();
	
	public List<PaymentSchedule> getParticularSchedules(Integer Id);
	
	public PaymentSchedule updatePaymentScheduleStatus(PaymentSchedule paymentSchedule) throws ResourceNotFoundException;
	
	public PaymentSchedule updatePaymentScheduleStatusToAwaiting(PaymentSchedule paymentSchedule) throws ResourceNotFoundException;

}
