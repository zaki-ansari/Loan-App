import { Component, OnInit, TemplateRef } from '@angular/core';
import { Router } from '@angular/router';
import { BsModalService,BsModalRef } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  modalRef!: BsModalRef;
  config = {
    animated: true,
    
    ignoreBackdropClick: true,
    class: "alert alert-danger"
  };
  constructor(private router:Router,
    private modalservice:BsModalService) { }

  ngOnInit(): void {
  }

  onLogout(popUp:TemplateRef<any>){
    
    this.modalRef = this.modalservice.show(popUp, this.config);
   
    localStorage.removeItem("data");
  }

  onBack(){
    localStorage.removeItem("data");
  }
  // onLogout(){
  //   this.router.navigate(['/login']);
  // }
}
