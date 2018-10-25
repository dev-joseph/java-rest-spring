import {Component} from '@angular/core';
import {MyserviceService} from './myservice.service'
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(svc:MyserviceService,private http:HttpClient){
        svc.printConsole("some print from root app....");

    let obsObject = this.http.get("https://api.github.com/users/inv-joseph");

    obsObject.subscribe((response)=> console.log(response));
  }
}
