package com.example.demo.service;

import com.example.demo.dto.Customer;
import com.example.demo.dto.LoanApplicationDto;
import com.example.demo.entities.CustomerEntity;
import com.example.demo.entities.LoanApplication;
import com.example.demo.exception.ApplicationAlreadyExists;
import com.example.demo.exception.ApplicationIdNotFound;
import com.example.demo.exception.CustomerAlreadyExistsException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.repository.LoanApplicationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationService implements ILoanApplicationService {
	@Autowired
	private LoanApplicationRepository loanApplicationRepository;
	static Logger log = Logger.getLogger(LoanApplicationService.class.getName());

	public LoanApplicationDto addLoanApplication(LoanApplicationDto loanApplicationDto) throws ApplicationAlreadyExists{
		log.info("starting of the addLoanApplication method");

		LoanApplication loanApplication = ConvertDTOToEntity(loanApplicationDto);
		
		Optional<LoanApplication> findloanApplicationDto=loanApplicationRepository.findById(ConvertDTOToEntity(loanApplicationDto).getId());
		
		
		if(findloanApplicationDto.isPresent()) {
			throw new ApplicationAlreadyExists("application already Exists");
		}

		
		LoanApplication loanApplication1= loanApplicationRepository.save(loanApplication);
		log.info("ending of the addLoanApplication method");

		return ConvertEntityToDto(loanApplication1);
		
	}

	public List<LoanApplicationDto> retrieveAllLoanApplication() {
		log.info("starting of the retrieve all LoanApplication method");

		List<LoanApplicationDto> applicationDtoList = new ArrayList<LoanApplicationDto>();
		List<LoanApplication> applicationList = loanApplicationRepository.findAll();

		for (LoanApplication loan : applicationList) {
			applicationDtoList.add(ConvertEntityToDto(loan));
		}
		log.info("ending of the retrieve all LoanApplication method");

		return applicationDtoList;
	}

	public List<LoanApplicationDto> deleteLoanApplication(Integer loanApplicationId) throws ApplicationIdNotFound {
		log.info("starting of the deleteLoanApplication method");
		
Optional<LoanApplication> findloanApplicationDto=loanApplicationRepository.findById(loanApplicationId);
		
		if(findloanApplicationDto.isEmpty()) {
			throw new ApplicationIdNotFound("application not found");
		}

		loanApplicationRepository.deleteById(loanApplicationId);

		log.info("ending of the deleteLoanApplication method");

		return retrieveAllLoanApplication();
	}

	public List<LoanApplicationDto> updateLoanApplication(LoanApplicationDto loanApplicationDto) throws ApplicationIdNotFound {
		log.info("starting of the updateLoanApplication method");
		
Optional<LoanApplication> findloanApplicationDto=loanApplicationRepository.findById(ConvertDTOToEntity(loanApplicationDto).getId());
		
		
		if(findloanApplicationDto.isEmpty()) {
			throw new ApplicationIdNotFound("application already Exists");
		}
		
		

		ConvertEntityToDto(loanApplicationRepository.save(ConvertDTOToEntity(loanApplicationDto)));
		// TODO Auto-generated method stub
		log.info("ending of the updateLoanApplication method");

		return retrieveAllLoanApplication();
	}

	public LoanApplicationDto retrieveLoanApplicationById(Integer loanApplicationId) throws ApplicationIdNotFound{
		log.info("starting of the retrieveLoanApplicationById method");
		
Optional<LoanApplication> findloanApplicationDto=loanApplicationRepository.findById(loanApplicationId);
		
		if(findloanApplicationDto.isEmpty()) {
			throw new ApplicationIdNotFound("application not found");
		}

		Optional<LoanApplication> loanApplication = loanApplicationRepository.findById(loanApplicationId);
		log.info("ending of the retrieveLoanApplicationById method");

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
