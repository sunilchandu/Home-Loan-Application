package com.example.demo.dto;

import java.time.LocalDate;

public class Customer{

private int userId;
private String customerName;
private String mobileNumber;
private String emailId;
private LocalDate dateOfBirth;
private String gender;
private String nationality;
private String aadharNumber;
private String panNumber;

public Customer() {
	super();
}
public Customer(int userid, String customerName, String mobileNumber, String emailId, LocalDate dateOfBirth,
		String gender, String nationality, String aadharNumber, String panNumber) {
	super();
	this.userId=userid;
	this.customerName = customerName;
	this.mobileNumber = mobileNumber;
	this.emailId = emailId;
	this.dateOfBirth = dateOfBirth;
	this.gender = gender;
	this.nationality = nationality;
	this.aadharNumber = aadharNumber;
	this.panNumber = panNumber;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public LocalDate getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getNationality() {
	return nationality;
}
public void setNationality(String nationality) {
	this.nationality = nationality;
}
public String getAadharNumber() {
	return aadharNumber;
}
public void setAadharNumber(String aadharNumber) {
	this.aadharNumber = aadharNumber;
}
public String getPanNumber() {
	return panNumber;
}
public void setPanNumber(String panNumber) {
	this.panNumber = panNumber;
}




}
