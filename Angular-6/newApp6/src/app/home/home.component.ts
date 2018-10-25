import { Component, OnInit } from '@angular/core';
import {User} from '../address-card/user.model'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  title = ' newApp6 !!!!';
  user:User;
  inputText:String = "Just a value";

  constructor() {
    this.user = new User();
    this.user.name = "Shiva Narayanan";
    this.user.designation = "Chemical Engineer";
    this.user.address = "Kavalipuram North, Chennai 16";
    this.user.phone = ['049535255822','454583233355'];
  }

  ngOnInit() {
  }

}
