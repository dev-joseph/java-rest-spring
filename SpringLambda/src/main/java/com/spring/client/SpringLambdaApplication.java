package com.spring.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLambdaApplication {

	public static void main(String[] args) {
		
		LambdaType lambdaExp = ()->{
			System.out.println("Hello from LAMBDA ....");
		};
		
		lambdaExp.perform();
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		//people.forEach(p -> System.out.println(p));
		
		//people.forEach(System.out::println);
		
		people.stream()
		.filter(p->p.getFirstName().startsWith("C"))
		.forEach(p->System.out.println(p.getFirstName()));
		
		//SpringApplication.run(SpringLambdaApplication.class, args);
	}
}