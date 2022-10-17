package com.finzly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.entity.PaymentSchedule;
import com.finzly.payload.LoanDto;
import com.finzly.service.PaymentScheduleService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/paymentSchedule")
public class PaymentScheduleController {
	
	@Autowired
	private PaymentScheduleService paymentScheduleService;
	
	
	@PostMapping("/create")
	public ResponseEntity<List<PaymentSchedule>> createSchedules(@RequestBody LoanDto loanDto){
	
		List<PaymentSchedule> schedules = this.paymentScheduleService.createPaymentSchedules(loanDto);
		
		return new ResponseEntity<List<PaymentSchedule>>(schedules,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PaymentSchedule>> getAllSchedules(){
	
		List<PaymentSchedule> schedules = this.paymentScheduleService.getAllPaymentSchedules();
		
		return new ResponseEntity<List<PaymentSchedule>>(schedules,HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<List<PaymentSchedule>> getParticularSchedules(@PathVariable Integer Id){
		
		List<PaymentSchedule> schedules = this.paymentScheduleService.getParticularSchedules(Id);
		return new ResponseEntity<List<PaymentSchedule>>(schedules,HttpStatus.OK);
		
	}
	
	@PutMapping("/updatestatus")
	public ResponseEntity<PaymentSchedule> updatePaymentScheduleStatus(@RequestBody PaymentSchedule paymentSchedule){
		PaymentSchedule paymentSchedule1 = this.paymentScheduleService.updatePaymentScheduleStatus(paymentSchedule);
		
		return new ResponseEntity<PaymentSchedule>(paymentSchedule1,HttpStatus.OK);
		
	}
	
	@PutMapping("/updatestatustoawaiting")
	public ResponseEntity<PaymentSchedule> updatePaymentScheduleStatusToAwaiting(@RequestBody PaymentSchedule paymentSchedule){
		PaymentSchedule paymentSchedule1 = this.paymentScheduleService.updatePaymentScheduleStatusToAwaiting(paymentSchedule);
		
		return new ResponseEntity<PaymentSchedule>(paymentSchedule1,HttpStatus.OK);
		
	}
}
