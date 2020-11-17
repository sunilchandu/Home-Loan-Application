package com.example.demo.dto;

public class LandVerificationOfficer {
	private int userId;
	private String officerName;
	private String officerContact;
	public LandVerificationOfficer(int userId, String officerName, String officerContact) {
		super();
		this.userId = userId;
		this.officerName = officerName;
		this.officerContact = officerContact;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOfficerName() {
		return officerName;
	}
	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}
	public String getOfficerContact() {
		return officerContact;
	}
	public void setOfficerContact(String officerContact) {
		this.officerContact = officerContact;
	}
	

}
