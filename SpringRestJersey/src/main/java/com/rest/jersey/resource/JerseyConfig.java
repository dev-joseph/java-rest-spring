package com.rest.jersey.resource;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.rest.jersey.exeption.DataNotFoundExeptionMapper;
import com.rest.jersey.filter.AuthenticationFilter;
import com.rest.jersey.exeption.AuthenticationFailExceptionMapper;

@Component
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig(){
        register(MessageResource.class);
        register(ProfileResource.class);
        register(AnnotationResource.class);
        register(AuthenticationFilter.class);
        register(AuthenticationFailExceptionMapper.class);
        //register(CommentResource.class);
        //register(DataNotFoundExeptionMapper.class);
    }
}
