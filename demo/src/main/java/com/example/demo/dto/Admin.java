package com.example.demo.dto;

public class Admin {
private int userId;
private String adminName;
public Admin(int userId, String adminName, String adminContact) {
	super();
	this.userId = userId;
	this.adminName = adminName;
	this.adminContact = adminContact;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminContact() {
	return adminContact;
}
public void setAdminContact(String adminContact) {
	this.adminContact = adminContact;
}
private String adminContact;
}
