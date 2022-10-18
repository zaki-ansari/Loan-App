import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-createloan',
  templateUrl: './createloan.component.html',
  styleUrls: ['./createloan.component.css']
})
export class CreateloanComponent implements OnInit {

  
  paymentTerms:any[]=[
    "Interest Only",
    "Even Principal"
  ]
  paymentFrequencies:any[]=[
    "Monthly",
    "Quarterly",
    "HalfYearly",
    "Yearly"
  ]
  
 constructor(private service:HttpService,
            private router:Router,
            private toastr:ToastrService){

 }
 ngOnInit(): void {
     
 }

 onSubmit(f:NgForm){

  let obj={
    loanAmount:f.value.loanamount,
    paymentTerm:f.value.payterm,
    loanTerm:f.value.loanterm,
    paymentFrequency:f.value.paymentfrequency,
    interestRate:f.value.interestrate
    
  }
  console.log(obj);
  this.service.createLoan(obj)
  .subscribe((response)=>{
    console.log(response);
    this.toastr.success("Loan Created Successfully");

    f.resetForm();
    
    
  })
  
 }

}


