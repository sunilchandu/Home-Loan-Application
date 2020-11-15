package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity(name = "customer")
@Table(name="customer")
public class Customer{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int userId;
	private String customerName;
	private String mobileNumber;
	@Column(unique = true)
	private String emailId;
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	private String gender;
	private String nationality;
	private String aadharNumber;
	private String panNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "application_id")
	private LoanApplication loanApplication;

	public Customer(String customerName, String mobileNumber, String emailId, LocalDate dateOfBirth, String gender, String nationality, String aadharNumber, String panNumber, LoanApplication loanApplication) {
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.loanApplication = loanApplication;
	}

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}

	public Customer() {
		super();
	}
	public Customer( String customerName, String mobileNumber, String emailId, LocalDate dateOfBirth,
					String gender, String nationality, String aadharNumber, String panNumber) {
		super();
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
	}


	public Customer(int userId, String customerName, String mobileNumber, String emailId, LocalDate dateOfBirth, String gender, String nationality, String aadharNumber, String panNumber, LoanApplication loanApplication) {
		this.userId = userId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.loanApplication = loanApplication;
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

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", customerName=" + customerName + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", nationality="
				+ nationality + ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + "]";
	}
}
