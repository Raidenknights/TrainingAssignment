package com.example.MyWeb.UserService.Exceptions;

import java.util.Date;

public class ExceptionModel {
	private Date timeStamp;
	private String problem;
	private String message;
	public ExceptionModel(Date timeStamp, String problem, String message) {
		super();
		this.timeStamp = timeStamp;
		this.problem = problem;
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
