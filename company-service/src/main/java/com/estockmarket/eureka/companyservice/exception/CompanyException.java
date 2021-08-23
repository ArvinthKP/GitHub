package com.estockmarket.eureka.companyservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class CompanyException {

	@ExceptionHandler(value 
		      = RuntimeException.class)
	  protected ResponseEntity<Object> handleRuntimeException(Exception ex, WebRequest request) {
	    log.info("global exception handler " + ex.getMessage());	    
	    ResponseEntity<Object> ret = ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
	    return ret;
	  }
}
