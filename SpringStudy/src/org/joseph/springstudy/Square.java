package org.joseph.springstudy;

import java.util.List;

public class Square implements Shape{
	
	private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void draw() {	
		System.out.println(" --------------- Square --------------- ");
		for(Point point: points) {
			System.out.println(point.getX() + " -------- Square --------" + point.getY());
		}
		System.out.println(" --------------- Square ends --------------- ");
	}
	
	public void initCalled() {
		System.out.println("Init Square method called");
	}
	
	public void destroyCalled() {
		System.out.println("Destroy Square method called");
	}

}
