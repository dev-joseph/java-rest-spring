export class Person{
	fName : string;
	lName : string;

	constructor(fName:string, lName:string){
		this.fName = fName;
		this.lName = lName;
	}

	getFullName(){
		return this.fName+" "+this.lName;
	}

	greet(){
		console.log("Hey From Class");
	}
}

class Programmer extends Person{
	greet(){
		console.log("Hey From Programmer");	
	}

	greetparent(){
	    super.greet();
	}
}



