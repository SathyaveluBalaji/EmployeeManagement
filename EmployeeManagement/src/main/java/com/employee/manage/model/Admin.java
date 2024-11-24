package com.employee.manage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity


public class Admin {
	


//private int id;
	@Id
private String emailId;
private String userName; 
private  String password;

public Admin() {
}

public Admin(String emailId, String userName, String password) {
	super();
	//this.id = id;
	this.emailId = emailId;
	this.userName = userName;
	this.password = password;
}

public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}
