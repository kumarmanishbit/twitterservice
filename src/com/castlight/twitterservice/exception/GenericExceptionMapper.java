package com.castlight.twitterservice.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.castlight.twitterservice.beans.ErrorMessage;
import com.sun.jersey.api.client.ClientResponse.Status;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(500);
		errorMessage.setErrorMessage(ex.getMessage());
		errorMessage.setDocumentation("http://www.google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
		
	}

}
