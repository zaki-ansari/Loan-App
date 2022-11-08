import { Component, OnInit } from '@angular/core';
import { MatDialog,MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { MatDialogSigninComponent } from '../mat-dialog-signin/mat-dialog-signin.component';
import { MatDialogSignupComponent } from '../mat-dialog-signup/mat-dialog-signup.component';

@Component({
  selector: 'app-homescreen',
  templateUrl: './homescreen.component.html',
  styleUrls: ['./homescreen.component.css']
})
export class HomescreenComponent implements OnInit {

  constructor(private router:Router,
              private dialog:MatDialog) { }

  ngOnInit(): void {
  }

  onBtnClick(){
    this.router.navigate(['/home']);
  }

  openDialogSignUp(){


    const dialogRef = this.dialog.open(MatDialogSignupComponent,{
      width: '30%',
      height: 'auto',
      autoFocus: false,
      disableClose: false
    });

    dialogRef.afterClosed().subscribe(result =>{
      console.log('dialog was closed.')
    })
  }

  openDialogSignIn(){


    const dialogRef = this.dialog.open(MatDialogSigninComponent,{
      width: '30%',
      height: 'auto'
    });

    dialogRef.afterClosed().subscribe(result =>{
      console.log('dialog was closed.')
    })
  }
}
