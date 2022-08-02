package com.scb.rpg.springplayground.config.payloads;

import java.time.LocalDateTime;

public class ApiExceptionPayload {
	
	String message;
	int status;
	String httpStatus;
	boolean success;
	boolean exception;
	LocalDateTime timestamp;
	String path;
	
	public ApiExceptionPayload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiExceptionPayload(String message, int status, String httpStatus, boolean success, boolean exception,
			LocalDateTime timestamp, String path) {
		super();
		this.message = message;
		this.status = status;
		this.httpStatus = httpStatus;
		this.success = success;
		this.exception = exception;
		this.timestamp = timestamp;
		this.path = path;
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	

}
