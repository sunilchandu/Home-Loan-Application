package com.example.demo.dto;

import java.time.LocalDate;

public class LoanApplicationDto{
	
	private int applicationId;
	private LocalDate applicationDate;
	private Customer customer;
	private double loanAppliedAmount;
	private double loanApprovedAmount;
	private String landVerificationApproval;
	private String financeVerificationApproval;
	private String adminApproval;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
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

	public String isLandVerificationApproval() {
		return landVerificationApproval;
	}

	public void setLandVerificationApproval(String landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}

	public String isFinanceVerificationApproval() {
		return financeVerificationApproval;
	}

	public void setFinanceVerificationApproval(String financeVerificationApproval) {
		this.financeVerificationApproval = financeVerificationApproval;
	}

	public String isAdminApproval() {
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

	public LoanApplicationDto( int applicationId,LocalDate applicationDate, Customer customer, double loanAppliedAmount,
			double loanApprovedAmount, String landVerificationApproval, String financeVerificationApproval,
			String adminApproval, Status status) {
		super();
		this.applicationId = applicationId;
		this.applicationDate = applicationDate;
		this.customer = customer;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoanApplication [applicationId=" + applicationId + ", applicationDate=" + applicationDate
				+ ", customer=" + customer + ", loanAppliedAmount=" + loanAppliedAmount + ", loanApprovedAmount="
				+ loanApprovedAmount + ", landVerificationApproval=" + landVerificationApproval
				+ ", financeVerificationApproval=" + financeVerificationApproval + ", adminApproval=" + adminApproval
				+ ", status=" + status + "]";
	}

	public LoanApplicationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
