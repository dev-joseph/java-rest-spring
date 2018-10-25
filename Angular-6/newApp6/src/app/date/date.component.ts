import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'date',
  templateUrl: './date.markup.html',
  styleUrls: ['./date.markup.css']
})
export class DateComponent implements OnInit {

  d = new Date();
  message: string;

  constructor() { 
	//this.message = "";
	setInterval(() => { 
	  let currentDate = new Date();        
	  this.message = currentDate.toDateString()+" "+currentDate.toLocaleTimeString();
	}, 1000);
  }

  ngOnInit() {
  }

}
