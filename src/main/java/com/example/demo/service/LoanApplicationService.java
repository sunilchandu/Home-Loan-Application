package com.example.demo.service;



import com.example.demo.entities.LoanApplication;
import com.example.demo.repository.LoanApplicationRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationService implements ILoanApplicationService {
	@Autowired
    private LoanApplicationRepository loanApplicationRepository;

    public LoanApplication addLoanApplication(LoanApplication loanApplication){
        return loanApplicationRepository.save(loanApplication);
    }
    
    public List<LoanApplication> retrieveAllLoanApplication() {
        return loanApplicationRepository.findAll();
    }
    
    public List<LoanApplication> deleteLoanApplication(Integer loanApplicationId) {
    	
    	loanApplicationRepository.deleteById(loanApplicationId);
    	
    	
    	
        return loanApplicationRepository.findAll();
    }
    
    public List<LoanApplication> updateLoanApplication(LoanApplication loanApplication) {
    
    	loanApplicationRepository.save(loanApplication);
		// TODO Auto-generated method stub
		return loanApplicationRepository.findAll();
	}
    
	public LoanApplication retrieveLoanApplicationById(Integer loanApplicationId) {
		
		Optional<LoanApplication> loanApplication= loanApplicationRepository.findById(loanApplicationId);
		
		return loanApplication.get();
	}

    
    
    
    
    
}

