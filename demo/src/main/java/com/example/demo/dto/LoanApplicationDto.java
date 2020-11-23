package com.example.demo.dto;
import com.example.demo.dto.Status;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import com.example.demo.entities.CustomerEntity;

public class LoanApplicationDto{
	
	private int applicationId;
	@FutureOrPresent
	@NotNull
	private LocalDate applicationDate;
	private CustomerEntity customer;
	@NotNull
	private double loanAppliedAmount;
	@NotNull
	private double loanApprovedAmount;
	@NotNull
	private String landVerificationApproval;
	@NotNull
	private String financeVerificationApproval;
	@NotNull
	private String adminApproval;
	@Enumerated(EnumType.STRING)
	private Status status;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}

	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}

	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}

	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}

	public String getLandVerificationApproval() {
		return landVerificationApproval;
	}

	public void setLandVerificationApproval(String landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}

	public String getFinanceVerificationApproval() {
		return financeVerificationApproval;
	}

	public void setFinanceVerificationApproval(String financeVerificationApproval) {
		this.financeVerificationApproval = financeVerificationApproval;
	}

	public String getAdminApproval() {
		return adminApproval;
	}

	public void setAdminApproval(String adminApproval) {
		this.adminApproval = adminApproval;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LoanApplicationDto( int applicationId,LocalDate applicationDate,  double loanAppliedAmount,
			double loanApprovedAmount, String landVerificationApproval, String financeVerificationApproval,
			String adminApproval, CustomerEntity customer, Status status) {
		super();
		this.applicationId = applicationId;
		this.applicationDate = applicationDate;
		this.customer = customer;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status=status;
		
	}

	

	@Override
	public String toString() {
		return "LoanApplication [id=" + applicationId + ", dateOfApplication=" + applicationDate
				+ ", loanAppliedAmount=" + loanAppliedAmount + ", loanApprovedAmount=" + loanApprovedAmount
				+ ", landVerificationApproval=" + landVerificationApproval + ", financeVerificationApproval="
				+ financeVerificationApproval + ", adminApproval=" + adminApproval + ", customer=" + customer + "]";
	}

	public LoanApplicationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
