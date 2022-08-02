package com.scb.rpg.springplayground.config.payloads;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiSuccessPayload {
	
	String message;
	int status;
	String httpStatus;
	boolean success;
	boolean exception;
	Object body;
	LocalDateTime timestamp;
	
	public ApiSuccessPayload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiSuccessPayload(String message, int status, String httpStatus, boolean success, boolean exception,
			Object body, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.status = status;
		this.httpStatus = httpStatus;
		this.success = success;
		this.exception = exception;
		this.body = body;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isException() {
		return exception;
	}

	public void setException(boolean exception) {
		this.exception = exception;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public static ApiSuccessPayload build(Object body,String message,HttpStatus status) {
		
		ApiSuccessPayload payload=new ApiSuccessPayload();
		
		payload.setSuccess(true);
		payload.setException(false);
		payload.setBody(body);
		payload.setMessage(message);
		payload.setStatus(status.value());
		payload.setHttpStatus(String.valueOf(status));
		payload.setTimestamp(LocalDateTime.now());
		
		return payload;
	}
	
	
	

}
