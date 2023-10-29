import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-mat-dialog-signup',
  templateUrl: './mat-dialog-signup.component.html',
  styleUrls: ['./mat-dialog-signup.component.css']
})
export class MatDialogSignupComponent implements OnInit {

  constructor(private http:HttpService,
              private toastr:ToastrService) { }

  ngOnInit(): void {
  }

  responeSignUp:string='';
  onSubmit(f:NgForm){
    let obj={
      userEmail:f.value.email,
      userPassword:f.value.password
    }
    console.log(obj);

    this.http.createUserSignUp(obj)
    .subscribe((response)=>{
        this.toastr.success("User created Successfully...");
    },(error)=>{
      this.toastr.info("User Already Exists...");
    })
  }
}
