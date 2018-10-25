import { Component, OnInit, Input } from '@angular/core';
import {User} from './user.model'
@Component({
  selector: 'app-address-card',
  templateUrl: './address-card.component.html',
  styleUrls: ['./address-card.component.css']
})
export class AddressCardComponent implements OnInit {

  user:any;

  @Input('user') userObj : User;
  @Input('name') userName: string;
  @Input('title') title: string;
  @Input('address') address: string;

  constructor() {
  }

  ngOnInit() {
    this.user = {
      name: this.userObj.name,
      title: this.userObj.designation,
      address: this.userObj.address,
      phone:this.userObj.phone,
    }
  }

}
