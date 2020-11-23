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
	Convertor c = new Convertor();

	public LoanApplicationDto addLoanApplication(LoanApplicationDto loanApplicationDto) throws ApplicationAlreadyExists{
		log.info("starting of the addLoanApplication method");
		
		if(loanApplicationDto==null) {
			return null;
		}

		LoanApplication loanApplication = c.ConvertDTOToEntity(loanApplicationDto);
		
		Optional<LoanApplication> findloanApplicationDto=loanApplicationRepository.findById(c.ConvertDTOToEntity(loanApplicationDto).getId());
		
		
		if(findloanApplicationDto.isPresent()) {
			throw new ApplicationAlreadyExists("ApplicationAlreadyExists");
		}

		
		LoanApplication loanApplication1= loanApplicationRepository.save(loanApplication);
		log.info("ending of the addLoanApplication method");

		return c.ConvertEntityToDto(loanApplication1);
		
	}

	public List<LoanApplicationDto> retrieveAllLoanApplication() {
		log.info("starting of the retrieve all LoanApplication method");

		List<LoanApplicationDto> applicationDtoList = new ArrayList<LoanApplicationDto>();
		List<LoanApplication> applicationList = loanApplicationRepository.findAll();
		if(applicationList==null) {
			return null;
		}
		

		for (LoanApplication loan : applicationList) {
			applicationDtoList.add(c.ConvertEntityToDto(loan));
		}
		log.info("ending of the retrieve all LoanApplication method");

		return applicationDtoList;
	}

	public LoanApplicationDto deleteLoanApplication(Integer loanApplicationId) throws ApplicationIdNotFound {
		log.info("starting of the deleteLoanApplication method");
		
Optional<LoanApplication> findloanApplication=loanApplicationRepository.findById(loanApplicationId);
		
		if(findloanApplication.isEmpty()) {
			throw new ApplicationIdNotFound("ApplicationIdNotFound");
		}

		loanApplicationRepository.deleteById(loanApplicationId);

		log.info("ending of the deleteLoanApplication method");

		return c.ConvertEntityToDto(findloanApplication.get());
	}

	public LoanApplicationDto updateLoanApplication(LoanApplicationDto loanApplicationDto) throws ApplicationIdNotFound {
		log.info("starting of the updateLoanApplication method");
		
		
Optional<LoanApplication> findloanApplicationDto=loanApplicationRepository.findById(c.ConvertDTOToEntity(loanApplicationDto).getId());


		
		
		if(findloanApplicationDto.isEmpty()) {
			throw new ApplicationIdNotFound("ApplicationIdNotFound");
		}
		
		
		LoanApplicationDto lp= c.ConvertEntityToDto(loanApplicationRepository.save(c.ConvertDTOToEntity(loanApplicationDto)));

		
		// TODO Auto-generated method stub
		log.info("ending of the updateLoanApplication method");

		return lp;
	}

	public LoanApplicationDto retrieveLoanApplicationById(Integer loanApplicationId) throws ApplicationIdNotFound{
		log.info("starting of the retrieveLoanApplicationById method");
		
Optional<LoanApplication> findloanApplicationDto=loanApplicationRepository.findById(loanApplicationId);
		
		if(findloanApplicationDto.isEmpty()) {
			throw new ApplicationIdNotFound("ApplicationIdNotFound");
		}

//		Optional<LoanApplication> loanApplication = loanApplicationRepository.findById(loanApplicationId);
		log.info("ending of the retrieveLoanApplicationById method");
		
		LoanApplication lp=findloanApplicationDto.get();

		return c.ConvertEntityToDto(lp);
	}
}

