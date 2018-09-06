package com.rest.jersey.resource;

import javax.ws.rs.PathParam;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

import com.rest.jersey.model.Link;
import com.rest.jersey.model.Message;
import com.rest.jersey.service.MessageService;



import com.rest.jersey.resource.bean.MessageFilterBean;
import com.rest.jersey.resource.CommentResource;

@Component
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	@Path("/getbean")
	public List<Message> getBeanMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	public List<Message> getMessages(@QueryParam("year") int year, 
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		if (start >= 0 && size > 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message),"profile");
		message.addLink(getUriForComment(uriInfo, message),"comments");
		return message;
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		String url = uriInfo.getBaseUriBuilder().path(ProfileResource.class)
		.path(String.valueOf(message.getAuthor()))
		.build()
		.toString();
		return url;
	}
	
	private String getUriForComment(UriInfo uriInfo, Message message) {
		String url = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId", message.getId())
		.build()
		.toString();
		return url;
	}
	
	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String url = uriInfo.getBaseUriBuilder().path(MessageResource.class)
		.path(String.valueOf(message.getId()))
		.build()
		.toString();
		return url;
	}

	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		
		Message newMessage = messageService.addMessage(message);
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
		
		return Response.created(uri).entity(newMessage).build();
		
		//return Response.status(Status.CREATED).entity(messageService.addMessage(message)).build();
		//return messageService.addMessage(message);
		//return messageService.getAllMessages();
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}	
	
}
