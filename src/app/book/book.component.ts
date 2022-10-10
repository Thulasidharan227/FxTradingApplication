import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  data:any[]=[];
  Message:string="";
  number:number=0;
  flag:number=1;
  backendResponse:string=""
  issubmitDissabled:boolean=true;
  constructor(private formbuilder:FormBuilder,private service:HttpService,private router:Router) { }

  ngOnInit(): void {
  
  }
  rate(getRate:any,transferAmount:any){
    this.number=(this.number+transferAmount.value)*66.0;
    if(getRate.checked && this.flag==1){
      this.Message=`Your tranferring the amount INR ${this.number} `;
      this.flag=0;
    }
    }
    onSubmit(values:any){
      this.data=values
      this.service.setValue(values).subscribe((response:any)=>{
        this.issubmitDissabled=false;
       alert(this.backendResponse=response)
       window.location.reload();
      })
    }
   
  }


