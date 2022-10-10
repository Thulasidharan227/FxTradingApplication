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

  popuppage(){
    let popo=document.getElementById("popup")
    popo?.classList.add("open")
    console.log("--------------------")
  }
  closepopup(){
    let popo=document.getElementById("popup")
    popo?.classList.remove("open")

  }
}
