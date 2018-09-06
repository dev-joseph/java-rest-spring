package com.rest.jersey.resource;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.rest.jersey.exeption.DataNotFoundExeptionMapper;

@Component
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig(){
        register(MessageResource.class);
        register(ProfileResource.class);
        register(AnnotationResource.class);
        //register(CommentResource.class);
        //register(DataNotFoundExeptionMapper.class);
    }
}
