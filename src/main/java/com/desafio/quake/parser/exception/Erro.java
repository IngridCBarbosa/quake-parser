package com.desafio.quake.parser.exception;

import java.io.Serializable;

public class Erro implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Integer errorCode;
	private String userMessage;
	private String developerMessage;
	
	public Erro(Integer errorCode, String userMessage, String developerMessage) {
		this.errorCode = errorCode;
		this.userMessage = userMessage;
		this.developerMessage = developerMessage;
	}
	
	public Erro() { }

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	@Override
	public String toString() {
		return "Erro [errorCode= " + errorCode + ", userMessage= " + userMessage + ", developerMessage= "+ developerMessage + "]";
	}
	
	
	

}
