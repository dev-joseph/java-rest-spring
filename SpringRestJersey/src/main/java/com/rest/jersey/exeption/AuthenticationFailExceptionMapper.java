package com.rest.jersey.exeption;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rest.jersey.model.ErrorMessage;

@Provider
public class AuthenticationFailExceptionMapper implements ExceptionMapper<AuthenticationFailException> {

	@Override
	public Response toResponse(AuthenticationFailException exception) {
		// TODO Auto-generated method stub
		ErrorMessage errMessage = new ErrorMessage(exception.getMessage(),401,"www.josephjohn.com");
		return Response.status(Status.UNAUTHORIZED).entity(errMessage).build();
	}

}
