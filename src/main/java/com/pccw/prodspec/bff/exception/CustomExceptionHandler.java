package com.pccw.prodspec.bff.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pccw.prodspec.bff.constants.Constants;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = CustomException.class)
	   public ResponseEntity<Object> handleInternalServerErrorException(CustomException ex) {
		Map<String,String> res=new HashMap<>();
		CustomException exceptionResponse = new CustomException(ex.getMessage(), ex.getDetails());
		res.put(Constants.MESSAGE, exceptionResponse.getMessage());
		res.put(Constants.DETAILS, exceptionResponse.getDetails());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	
	}
