package com.example.MyWeb.UserService.UserModel;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired 
	private UserRegistrationRepository userRegRepo;
	
	@PostMapping(path="/signup")
	public ResponseEntity<Object> createNewUser(@Email @RequestParam String email,@Valid @RequestParam String password,
			@RequestBody UserModel usermod){
		usermod.setEmail(email);
		usermod.setPass(password);
		usermod.setTimeStamp(new Date());
		userRegRepo.save(usermod);
		
		return new ResponseEntity("Congrats now you can LogIn",HttpStatus.CREATED);
	}
	
	
	@GetMapping(path="/getUsers")
	public ResponseEntity<Object> getUsers(){
		return new ResponseEntity(userRegRepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path ="/userDetails")
	public ResponseEntity<Object> getUserDetails(@Email @RequestParam String email){
		
		UserModel userModel = userRegRepo.findByEmail(email);
		if(userModel==null) {
			throw new UserNotFound("No user with emailID:"+email);
		}
		return new ResponseEntity(userModel,HttpStatus.FOUND);
	}
	
	
	@DeleteMapping(path="deleteUser")
	public ResponseEntity<Object> deleteUser(@Email @RequestParam String email,@RequestParam String password){
		
		UserModel userModel = userRegRepo.findByEmail(email);
		if(userModel==null) {
			throw new UserNotFound("Either email id or Password is not correct");
		}
		if(userModel.getPass().equals(password)) {
			userRegRepo.delete(userModel);
		}
		else {
			throw  new WrongCredentials("Either email id or Password is not correct");
		}
		return new ResponseEntity("We have deleted your account permanently",HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path="updateUser")
	public ResponseEntity<Object> updateUser(@Email @RequestParam String email, @RequestParam String oldPassword,@RequestParam String
			newPassword){
		UserModel userModel = userRegRepo.findByEmail(email);
		if(userModel==null || userModel.getPass().equals(oldPassword)==false) {
			throw new WrongCredentials("Either email id or Password is not correct");
		}
		userModel.setPass(newPassword);
		userRegRepo.save(userModel);
		return new ResponseEntity("Password has been updated",HttpStatus.OK);
	}
}
