import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-displayloans',
  templateUrl: './displayloans.component.html',
  styleUrls: ['./displayloans.component.css']
})
export class DisplayloansComponent implements OnInit {


  allLoans:any[]=[];
  constructor(private service:HttpService,
              private router:Router) { }

  ngOnInit(): void {
    this.getAllLoans();
  }

  p:number=1;


  getAllLoans(){
    this.service.getAllLoans()
    .subscribe((response:any)=>{
      this.allLoans=response;
      console.log(response);
    })
  }

  selected:number=-1;
  onMouseOver(obj:any){
    this.selected=obj.customerId;
    // console.log(obj.customerId);
  }

  onMouseOut(){
    this.selected=-1;
  }
  
  OnClickSchedule(obj:any){
    this.router.navigate(['/displayschedules',obj.customerId])
    // [routerLink]="['/displayschedules',item.customerId]"
  }
}
