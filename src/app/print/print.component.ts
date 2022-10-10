import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-print',
  templateUrl: './print.component.html',
  styleUrls: ['./print.component.css']
})
export class PrintComponent implements OnInit {
  datas:any[]=[];
  constructor(private http:HttpService) { }

  ngOnInit(): void {

    this.getvalues();
  }
  getvalues(){
    this.http.getValue().subscribe((response:any)=>{
     this.datas=response;
      console.log(response)
    })
  }
}
