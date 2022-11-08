import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  

  baseUrl:string='http://localhost:8080';
  constructor(private http:HttpClient) { }

  createLoan(obj:any){
   return (this.http.post(`${this.baseUrl}/loan/save`,obj));
  }

  createSchedules(obj:any){
    return (this.http.post(`${this.baseUrl}/paymentSchedule/create`,obj));
  }

  getAllSchedules() {
    return (this.http.get(`${this.baseUrl}/paymentSchedule/all`));

  }

  getAllLoans(){
    return (this.http.get(`${this.baseUrl}/loan/all`));
  }

  getParticularSchedules(id:any){
    return (this.http.get(`${this.baseUrl}/paymentSchedule/${id}`));
  }

  updateParticularScheduleStatus(obj:any){
    return (this.http.put(`${this.baseUrl}/paymentSchedule/updatestatus`,obj));
  }

  updateParticularScheduleStatusToAwaiting(obj:any){
    return (this.http.put(`${this.baseUrl}/paymentSchedule/updatestatustoawaiting`,obj));
  }

  createUserSignUp(obj:any){
    return (this.http.post(`${this.baseUrl}/userSignUp/create`,obj));
  }

  loginUserSignIn(obj:any){
   return (this.http.post(`${this.baseUrl}/userSignIn/login`,obj));
  }

  
}
