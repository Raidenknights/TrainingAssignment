package com.example.MyWeb.UserService.UserModel;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongCredentials extends RuntimeException {

	public WrongCredentials(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
