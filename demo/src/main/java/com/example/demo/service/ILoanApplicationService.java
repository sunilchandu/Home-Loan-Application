package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.LoanApplication;

public interface ILoanApplicationService {

	public LoanApplication addLoanApplication(LoanApplication loanApplication);

	public List<LoanApplication> retrieveAllLoanApplication();

	public LoanApplication retrieveLoanApplicationById(Integer loanApplicationId);
	public List<LoanApplication> deleteLoanApplication(Integer loanApplicationId);

	public List<LoanApplication> updateLoanApplication(LoanApplication loanApplication);

}
