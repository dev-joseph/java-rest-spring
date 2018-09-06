package com.rest.jersey.resource;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CommentResource {	
	@GET
	public String subResource() {
		return "Call from sub resource...";
	}
	
	@GET
	@Path("/{commentId}")
	public String getCommentById(@PathParam("messageId") String messageId,@PathParam("commentId") String commentId) {
		return messageId+" Call from sub param with id..." + commentId;
	}
}
