package com.example.demo.service;



import com.example.demo.dto.Customer;
import com.example.demo.dto.LoanApplicationDto;
import com.example.demo.entities.CustomerEntity;
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
	public CustomerEntity ConvertDTOToEntity(LoanApplicationDto loanApplicationDto) {
		CustomerEntity custEntity = new CustomerEntity();
		LoanApplication loanApplication= new LoanApplication();
		loanApplication.setId(loanApplicationDto.getApplicationId());
		loanApplication.
		return custEntity;
	}
//	public CustomerEntity ConvertDTOToEntity(Customer cust) {
//		CustomerEntity custEntity = new CustomerEntity();
//		custEntity.setUserId(cust.getUserId());
//		custEntity.setCustomerName(cust.getCustomerName());
//		custEntity.setAadharNumber(cust.getAadharNumber());
//		custEntity.setDateOfBirth(cust.getDateOfBirth());
//		custEntity.setEmailId(cust.getEmailId());
//		custEntity.setGender(cust.getGender());
//		custEntity.setMobileNumber(cust.getMobileNumber());
//		custEntity.setNationality(cust.getNationality());
//		custEntity.setPanNumber(cust.getPanNumber());
//		return custEntity;
//	}

    
    
    
    
    
}

