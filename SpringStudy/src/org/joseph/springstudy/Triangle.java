package org.joseph.springstudy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//public class Triangle implements InitializingBean, DisposableBean{
public class Triangle implements Shape{
	
//	private String type;
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private ApplicationContext context = null;
	
//	public Triangle(String type){
//		this.type = type;
//	}
	
	public void initCalled() {
		System.out.println("Init Triangle method called");
	}
	
	public void destroyCalled() {
		System.out.println("Destroy Triangle method called");
	}
	
	public void draw() {
		
		//Square sq = (Square) context.getBean("square");
		//sq.draw();
		System.out.println(" --------------- Triangle --------------- ");
		System.out.print(this.getPointA().getX()+ " Drawing with point " + this.getPointA().getY() + "\n");
		System.out.print(this.getPointB().getX()+ " Drawing with point " + this.getPointB().getY()+ "\n");
		System.out.print(this.getPointC().getX()+ " Drawing with point " + this.getPointC().getY()+ "\n");
		System.out.println(" --------------- Triangle ends--------------- ");
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

//	public String getType() {
//		return type;
//	}	
	

//	@Override
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("Triangle Bean initialization called");
//	}
//
//	@Override
//	public void destroy() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("Triangle Bean destroy method called");
//		
//	}

//	@Override
//	public void setApplicationContext(ApplicationContext context) throws BeansException {
//		// TODO Auto-generated method stub
//		this.context = context;
//	}

//	public void setType(String type) {
//		this.type = type;
//	}
}
