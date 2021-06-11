package com.example.MyWeb.UserService.Exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.MyWeb.UserService.UserModel.UserNotFound;
import com.example.MyWeb.UserService.UserModel.WrongCredentials;

@RestController
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex ,WebRequest web){
		
		ExceptionModel exceptionModel = new ExceptionModel(new Date(),ex.getMessage(),web.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionModel,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFound.class)
	public final ResponseEntity<Object> userNotFoundException(Exception ex,WebRequest web){
		
		ExceptionModel exceptionModel = new ExceptionModel(new Date(),ex.getMessage(),web.getDescription(false));
		
		return new ResponseEntity(exceptionModel,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(WrongCredentials.class)
	public final ResponseEntity<Object> handleWrongCredentials(Exception ex,WebRequest web){
		ExceptionModel exceptionModel = new ExceptionModel(new Date(),ex.getMessage(),web.getDescription(false));
		
		return new ResponseEntity(exceptionModel,HttpStatus.BAD_REQUEST);
	}
}
