package com.example.demo.service;



import com.example.demo.dto.Customer;
import com.example.demo.dto.LoanApplicationDto;
import com.example.demo.entities.CustomerEntity;
import com.example.demo.entities.LoanApplication;
import com.example.demo.repository.LoanApplicationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationService implements ILoanApplicationService {
	@Autowired
    private LoanApplicationRepository loanApplicationRepository;

    public LoanApplicationDto addLoanApplication(LoanApplicationDto loanApplicationDto){
    	
    	LoanApplication loanApplication= ConvertDTOToEntity(loanApplicationDto);
    	
    	
    	
    	
    	
        return ConvertEntityToDto(loanApplicationRepository.save(loanApplication));
    }
    
    public List<LoanApplicationDto> retrieveAllLoanApplication() {
    	List<LoanApplicationDto> applicationDtoList = new ArrayList<LoanApplicationDto>();
    	List<LoanApplication> applicationList = loanApplicationRepository.findAll();
    	
    	for(LoanApplication loan: applicationList) {
    		applicationDtoList.add(ConvertEntityToDto(loan));
    	}

    	
        return applicationDtoList;
    }
    
//    public List<Customer> viewAllCustomers() {
//		log.info("starting of the view all customers method");
//		List<Customer> custList = new ArrayList<Customer>();
//		List<CustomerEntity> custEntity = customerRepository.findAll();
//		for (CustomerEntity Cust : custEntity) {
//			custList.add(ConvertEntityToDTO(Cust));
//		}
//		log.info("end of the view all customers method");
//		return custList;
//		// return customerRepository.findAll();
//	}
//    
    public List<LoanApplicationDto> deleteLoanApplication(Integer loanApplicationId) {
    	
    	
    	loanApplicationRepository.deleteById(loanApplicationId);

    	
    	
    	
        return retrieveAllLoanApplication();
    }
    
    public List<LoanApplicationDto> updateLoanApplication(LoanApplicationDto loanApplicationDto) {
    
    	ConvertEntityToDto(loanApplicationRepository.save(ConvertDTOToEntity(loanApplicationDto)));
		// TODO Auto-generated method stub
		return retrieveAllLoanApplication();
	}
    
	public LoanApplicationDto retrieveLoanApplicationById(Integer loanApplicationId) {
		
		Optional<LoanApplication> loanApplication= loanApplicationRepository.findById(loanApplicationId);
		
		return ConvertEntityToDto(loanApplication.get());
	}
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
	   
         return loanApplication;
		
		
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
	   
         return loanApplicationDto;
		
		
	}
	


    
    
    
    
    
}

