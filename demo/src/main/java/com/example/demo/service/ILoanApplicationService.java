package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.LoanApplicationDto;
import com.example.demo.entities.LoanApplication;
import com.example.demo.exception.ApplicationAlreadyExists;
import com.example.demo.exception.ApplicationIdNotFound;

public interface ILoanApplicationService {

	public LoanApplicationDto addLoanApplication(LoanApplicationDto loanApplication) throws ApplicationAlreadyExists;

	public List<LoanApplicationDto> retrieveAllLoanApplication();

	public LoanApplicationDto retrieveLoanApplicationById(Integer loanApplicationId) throws ApplicationIdNotFound;
	public List<LoanApplicationDto> deleteLoanApplication(Integer loanApplicationId) throws ApplicationIdNotFound;

	public List<LoanApplicationDto> updateLoanApplication(LoanApplicationDto loanApplicationDto) throws ApplicationIdNotFound;

}
