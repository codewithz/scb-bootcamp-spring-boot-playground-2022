package com.scb.rpg.springplayground.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import com.scb.rpg.springplayground.config.payloads.ApiExceptionPayload;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value= {ResponseStatusException.class})
	public ResponseEntity<ApiExceptionPayload> handleApiException(ResponseStatusException exception, WebRequest request){
		
		String path=request.getDescription(false).replace("uri=", "");
//		1. Create a Payload for Exception
		ApiExceptionPayload payload=new ApiExceptionPayload(
						exception.getMessage(),
						exception.getStatus().value(), // 404 || 500
						String.valueOf(exception.getStatus()), //404 NOT_FOUND
						false,
						true, 
						LocalDateTime.now(),
						path);
//		2. Return the response entity
		ResponseEntity<ApiExceptionPayload> response=
				new ResponseEntity<ApiExceptionPayload>(payload, exception.getStatus());
		
		return response;
	}

}
