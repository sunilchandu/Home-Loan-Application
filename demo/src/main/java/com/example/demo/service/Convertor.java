package com.example.demo.service;

import com.example.demo.dto.LoanApplicationDto;
import com.example.demo.dto.Status;
import com.example.demo.entities.LoanApplication;
import com.example.demo.entities.StatusEntity;

public class Convertor{
	public LoanApplication ConvertDTOToEntity(LoanApplicationDto loanApplicationDto) {
		LoanApplication loanApplication = new LoanApplication();
		loanApplication.setId(loanApplicationDto.getApplicationId());
		loanApplication.setAdminApproval(loanApplicationDto.getAdminApproval());
		loanApplication.setDateOfApplication(loanApplicationDto.getApplicationDate());
		loanApplication.setFinanceVerificationApproval(loanApplicationDto.getFinanceVerificationApproval());
		loanApplication.setLandVerificationApproval(loanApplicationDto.getLandVerificationApproval());
		loanApplication.setCustomer(loanApplicationDto.getCustomer());
		loanApplication.setLoanAppliedAmount(loanApplicationDto.getLoanAppliedAmount());
		loanApplication.setLoanApprovedAmount(loanApplicationDto.getLoanApprovedAmount());
		loanApplication.setStatus(change(loanApplicationDto.getStatus()));

		return loanApplication;

	}
	public static StatusEntity change(Status status) {
		return StatusEntity.valueOf(status.toString());
	}

	public static Status change(StatusEntity statusEntity) {
		return Status.valueOf(statusEntity.toString());
	}

	public LoanApplicationDto ConvertEntityToDto(LoanApplication loanApplication) {
		LoanApplicationDto loanApplicationDto = new LoanApplicationDto();
		loanApplicationDto.setApplicationId(loanApplication.getId());
		loanApplicationDto.setAdminApproval(loanApplication.getAdminApproval());
		loanApplicationDto.setApplicationDate(loanApplication.getDateOfApplication());
		loanApplicationDto.setFinanceVerificationApproval(loanApplication.getFinanceVerificationApproval());
		loanApplicationDto.setLandVerificationApproval(loanApplication.getLandVerificationApproval());
		loanApplicationDto.setCustomer(loanApplication.getCustomer());
		loanApplicationDto.setLoanAppliedAmount(loanApplication.getLoanAppliedAmount());
		loanApplicationDto.setLoanApprovedAmount(loanApplication.getLoanApprovedAmount());
		loanApplicationDto.setStatus(change(loanApplication.getStatus()));

		return loanApplicationDto;

	}
}

