import {Person} from './typeClass'

class Admin extends Person{

}

class Manager extends Person{

}

let admin = new Admin('Jose', 'John');

console.log(admin.getFullName());

let manage = new Manager('Manog', 'Jins');

console.log(manage.getFullName());
