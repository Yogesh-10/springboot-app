package com.yogesh.springbootproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yogesh.springbootproject.entity.ErrorMessage;

//when ever there is an error in controller layer, we have to fetch or identify exception thrown and
//whenever exception is there, we have to sent back response based on exception thrown

@ControllerAdvice //It allows you to handle exceptions across the whole application, not just to an individual controller
//we can also handle exception to particular controller by mentioning in params @ControllerAdvice(assignableTypes = {DepartmentController.class})
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception, 
			WebRequest request){
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage); //we are sending error response with status code and message
	}
}

//The process for exception handling:
//1. The request comes to controller and exception is thrown at controller layer
//2. after exception is thrown, the DepartmentNotFoundException will come to this RestResponseEntityExceptionHandler
//because we added @controlleAdvice, and the above method will handle that exception, if we have multiple exceptions
//we can create multiple methods and handle that exception
//3. This class will return ResponseEntity with status and httpcodes










