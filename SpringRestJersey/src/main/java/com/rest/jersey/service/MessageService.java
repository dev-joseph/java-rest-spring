package com.rest.jersey.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;

import com.rest.jersey.demodb.DatabaseClass;
import com.rest.jersey.model.ErrorMessage;
import com.rest.jersey.model.Message;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.rest.jersey.exeption.DataNotFoundExeption;

public class MessageService {
private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Joseph"));
		messages.put(2L, new Message(2, "Hello Jersey", "koushik"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values()); 
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size); 
	}
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
//		if(message == null) {
//			throw new DataNotFoundExeption("Message with id " + id + " not found");
//		}
		ErrorMessage errMessage = new ErrorMessage("Data not found",404,"www.josephjohn.com");
		 
		if(message == null) {
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity(errMessage).build()); 
			//DataNotFoundExeption("Message with id " + id + " not found");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
