import { Component, OnInit } from '@angular/core';
import {MyserviceService} from '../../myservice.service'
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-new-component',
  templateUrl: './new-component.component.html',
  styleUrls: ['./new-component.component.css']
})
export class NewComponentComponent implements OnInit {

  userName: String = "";
  response:any;
  constructor(private svc:MyserviceService,private http:HttpClient) {
    svc.printConsole("Data from new module...");
  }

  ngOnInit() {
  }

  search(){
    this.http.get("https://api.github.com/users/"+this.userName)
    .subscribe((response)=>{
      console.log(response);
      this.response = response;
    });
  }

}
