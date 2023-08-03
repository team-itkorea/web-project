package com.example.practice.handler.exception;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class CustomValidationApiException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
	private Map<String, String> errorMap;
	
	public CustomValidationApiException() {
		this("error", new HashMap<String,String>());
	}
	
	public CustomValidationApiException(String message) {
		this(message, new HashMap<String,String>());
	}
	
	public CustomValidationApiException(String message, Map<String, String> errorMap) {
		super(message);
		this.errorMap = errorMap;
	}
	

}
