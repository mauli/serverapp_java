package com.demo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice //@ControllerAdvice class to handle the exceptions globally
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(Exception.class)
	  public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse("99", ex.getLocalizedMessage());
	    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	  }
	@ExceptionHandler(value = WeatherNotFoundException.class) //custom exception with custom class
	   public ResponseEntity<Object> exception(WeatherNotFoundException exception) {
		ErrorResponse errorDetails = new ErrorResponse("01", "Invalid ID. Please enter a valid weather ID");
	      return new ResponseEntity<>(errorDetails, HttpStatus.OK);
	   }
}
