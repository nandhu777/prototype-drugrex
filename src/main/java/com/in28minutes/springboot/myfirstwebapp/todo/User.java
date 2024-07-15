package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String name;
    
	private String emailAddress;
	private String text;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

 
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}