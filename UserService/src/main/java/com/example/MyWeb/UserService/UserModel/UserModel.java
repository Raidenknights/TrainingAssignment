package com.example.MyWeb.UserService.UserModel;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class UserModel {
	
	@Id
	@GeneratedValue
	private int idUser;
	@Size(min=5,max=12)
	private String customerId;
	private String email;
	private Date timeStamp;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String pass;
	
	public UserModel() {
		super();
	}
	public UserModel(int idUser, String customerId, String email, Date timeStamp, String pass) {
		super();
		this.idUser = idUser;
		this.customerId = customerId;
		this.email = email;
		this.timeStamp = timeStamp;
		this.pass = pass;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
