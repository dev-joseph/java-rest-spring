package org.joseph.springstudy;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {
	
	
	private Point center;
	
	@Autowired
	private MessageSource msgSource;

	public MessageSource getMsgSource() {
		return msgSource;
	}

	public void setMsgSource(MessageSource msgSource) {
		this.msgSource = msgSource;
	}

	public Point getCenter() {
		return center;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
		System.out.println(this.msgSource.getMessage("points", new Object[] { center.getX(),center.getY() }, "Default point message from classs", Locale.US));
		//System.out.println("Drawing circle with points "+this.getCenter().getX()+ ","+center.getY());
		
	}
	
	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	
}
