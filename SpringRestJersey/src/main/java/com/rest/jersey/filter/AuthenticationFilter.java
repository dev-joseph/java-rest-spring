package com.rest.jersey.filter;

import com.rest.jersey.exeption.AuthenticationFailException;
import com.rest.jersey.model.Profile;
import com.rest.jersey.secure.Secured;
import com.rest.jersey.service.ProfileService;

import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.AuthenticationServiceException;



@Component
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)

public class AuthenticationFilter implements ContainerRequestFilter {
	
	@Autowired
	ProfileService profileService;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer")) {
            throw new NotAuthorizedException("Authorization header must be provided");
        }
        
        String token = authorizationHeader.substring("Bearer".length()).trim();
        String profId = requestContext.getUriInfo().getPathParameters().getFirst("profileName");
       
        try {
        	validateToken(token, profId);
        }catch (AuthenticationServiceException ex) {
            Logger.getLogger(AuthenticationFilter.class.getName()).log(Level.SEVERE, null, ex);
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED).build());
        }		
	}
	
	private void validateToken(String token, String profId) throws AuthenticationServiceException {
		
		Profile profile = profileService.getProfile(profId);
		
		if(!profile.getToken().equals(token)) {
			throw new AuthenticationFailException("Given token is not matching with that user");
		}
	}
	
	
}
