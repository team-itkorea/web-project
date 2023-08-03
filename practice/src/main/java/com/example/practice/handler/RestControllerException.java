package com.example.practice.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.CMRespDto;
import com.example.practice.handler.exception.CustomValidationApiException;

@RestController
@ControllerAdvice
public class RestControllerException {
	
	@ExceptionHandler(CustomValidationApiException.class)
	public ResponseEntity<?> validationApiException(CustomValidationApiException e) {
		return ResponseEntity.ok().body(new CMRespDto<>(-1,e.getMessage(),e.getErrorMap()));
	}

}
