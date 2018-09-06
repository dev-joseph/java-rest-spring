package com.rest.jersey.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.HttpHeaders;

@Path("/annotate")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class AnnotationResource {

	@GET
	public String getProfileMatrix(@MatrixParam("param") String param,
								  @HeaderParam("header-param") String headerParam,
								  @CookieParam("my-cookie") String cookieParam) {
		return "Matrix:"+param+", Header:"+headerParam+", Cookie content : "+cookieParam;
	}
	
	@GET
	@Path("/context")
	public String getContextContent(@Context UriInfo uriInfo, @Context HttpHeaders header) {
		return "URL Info:"+ uriInfo.getAbsolutePath().toString()+", HttpHeader: "+header.getCookies().toString();
	}
}
