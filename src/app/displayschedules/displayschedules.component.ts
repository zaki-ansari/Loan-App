import { Component, OnInit, AfterViewInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpService } from '../http.service';
import { ToastrService } from 'ngx-toastr';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-displayschedules',
  templateUrl: './displayschedules.component.html',
  styleUrls: ['./displayschedules.component.css']
})
export class DisplayschedulesComponent implements OnInit,AfterViewInit {

  loanId:string|null="";
  allSchedules:any[]=[];
  datePipeString:string|null='';
  constructor(private service:HttpService,
              private route:ActivatedRoute,
              private toastr:ToastrService,
              private datePipe: DatePipe) { 
                this.datePipeString=datePipe.transform(Date.now(),'yyyy-MM-dd');
              }
  ngAfterViewInit(): void {
   
    
  }

  ngOnInit(): void {
    // this.getOverAllSchedules();
    this.GetDataFromUrl();

    if(this.flag){
      this.changeStatus();
    }
    
    
    
  }
  
  data:any;
  nextPaymentDate:String='';
  
  p:number=1;
  
  //bd=buttondisplay
  bd:any="-1";
  bd1:number=0;
  //cs=changestatus
  cs:number=0
  
 
  flag:boolean=false;
  flag1:boolean=true;
  flag2:boolean=false;

  
  
  

  changeStatus(){
    console.log(this.datePipeString);
    console.log(this.allSchedules);
    console.log("await");
    let obj=this.allSchedules[this.bd];
    console.log(obj);
    console.log(obj.paymentDate);
    if(this.allSchedules[this.bd].paymentDate==this.datePipeString && this.allSchedules[this.bd].paymentStatus=="PROJECTED"){
      this.service.updateParticularScheduleStatusToAwaiting(obj)
      .subscribe((response)=>{
        console.log(response);
        this.GetDataFromUrl();
        this.flag=true;
        console.log(this.flag);
        this.flag1=false;
        this.flag2=true;
      })
    }
  }

  getOverAllSchedules(){
    this.service.getAllSchedules()
    .subscribe((response:any)=>{
      this.allSchedules=response;
    })
  }
 
  GetDataFromUrl(){
    this.route.paramMap
    .subscribe((param)=>{
      console.log(param.get("id"));
      this.loanId=param.get("id");
      this.service.getParticularSchedules(param.get("id"))
      .subscribe((response:any)=>{
        console.log(response);
        this.allSchedules=response;
        localStorage.removeItem(this.bd);
        console.log(this.bd);
        localStorage.removeItem(this.bd);
        for(let i=0;i<this.allSchedules.length;i++){
          // console.log(this.allSchedules[i].paymentStatus)
          if(i==0){
            this.bd="0";
            console.log("done");
            // localStorage.removeItem("data");
          }
           if(this.allSchedules[i].paymentStatus==="PAID"){
              
              this.bd= (+this.bd)+1;
              console.log(this.bd);
              
           }
           localStorage.setItem("data",this.bd);
          //  console.log("running");
          // this.bd=this.bd+1;
        }
        this.changeStatus();
        
      })
    })
  }

  

  onPay(obj:any){
    if(obj.paymentStatus=="AWAITINGPAYMENT" && obj.paymentDate==this.datePipeString){

      if(confirm("Do you want to pay "+ obj.paymentAmount)){
        this.toastr.success("Payment of "+obj.paymentAmount+" of schedule Id "+obj.paymentScheduleId+" and loanId of "+this.loanId+" is succesfull");
      }else{
        this.toastr.warning("payment is cancelled");
        return;
      }
      console.log(obj);
    this.bd= (+this.bd)+1;
    console.log(this.bd);
    localStorage.removeItem(this.bd);
    this.service.updateParticularScheduleStatus(obj)
    .subscribe((response)=>{
      console.log(response);
      this.GetDataFromUrl();
    })
    
    
    }else{

      alert("Wait untill payment date is arrived and status will be AWAITINGPAYMENT");
    }
    
  }

  onBack(){
    localStorage.removeItem("data");
  }

}
