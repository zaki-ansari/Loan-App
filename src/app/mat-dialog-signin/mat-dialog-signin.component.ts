import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-mat-dialog-signin',
  templateUrl: './mat-dialog-signin.component.html',
  styleUrls: ['./mat-dialog-signin.component.css']
})
export class MatDialogSigninComponent implements OnInit {

  constructor(private http:HttpService,
              private toastr:ToastrService) { }

  ngOnInit(): void {
  }

  onSubmit(f:NgForm){
    let obj={
      userEmail:f.value.email,
      userPassword:f.value.password
    }
    console.log(obj);

    this.http.loginUserSignIn(obj)
    .subscribe((response)=>{
        this.toastr.success("LogIn Successfull");
    },(error)=>{
      this.toastr.info("User Already Exists...");
    })
  }
}
