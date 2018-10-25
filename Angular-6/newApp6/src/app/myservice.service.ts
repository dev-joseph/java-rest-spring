import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MyserviceService {

  printConsole(arg){
    console.log(arg);
  }
}
