package com.rest.jersey.exeption;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rest.jersey.model.ErrorMessage;
import com.rest.jersey.exeption.DataNotFoundExeption;

@Provider
public class DataNotFoundExeptionMapper implements ExceptionMapper<DataNotFoundExeption> {

	@Override
	public Response toResponse(DataNotFoundExeption ex) {
		// TODO Auto-generated method stub
		ErrorMessage errMessage = new ErrorMessage(ex.getMessage(),404,"www.josephjohn.com");
		return Response.status(Status.NOT_FOUND).entity(errMessage).build();
	}

}
																																																																																