package org.joseph.springstudy;

import org.joseph.springstudy.Triangle;

import java.util.Locale;

import org.joseph.springstudy.Circle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("Spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		//context.registerShutdownHook();
		
//		Triangle tr = (Triangle) context.getBean("triangle");
//		tr.draw();
//		
		Square sq = (Square) context.getBean("square");
		sq.draw();
		
		Shape shp = (Shape) context.getBean("triangle");
		shp.draw();
		
		shp = (Shape) context.getBean("circle");
		shp.draw();
				
		//System.out.println(context.getMessage("greet", null, "Default message from classs", null));
		
	}

}

