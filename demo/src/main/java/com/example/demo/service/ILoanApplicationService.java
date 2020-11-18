package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.LoanApplicationDto;
import com.example.demo.entities.LoanApplication;

public interface ILoanApplicationService {

	public LoanApplicationDto addLoanApplication(LoanApplicationDto loanApplication);

	public List<LoanApplicationDto> retrieveAllLoanApplication();

	public LoanApplicationDto retrieveLoanApplicationById(Integer loanApplicationId);
	public List<LoanApplicationDto> deleteLoanApplication(Integer loanApplicationId);

	public List<LoanApplicationDto> updateLoanApplication(LoanApplicationDto loanApplicationDto);

}
