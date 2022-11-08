import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  
  _tmpIntroHeadline: string = 'Welcome to Consumer Loan Application';
  _tmpIntroDesc: string = 'Click on Create Loan button to create a loan and Trade date will be Loan creation date ';
  _tmpIntroDesc2: string = 'Loan Start Date will be 10 days from the Trade date ';
  _tmpIntroFooter = 'Thank you.'

}
