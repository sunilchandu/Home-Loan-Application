package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.dto.LoanApplicationDto;
import com.example.demo.entities.LoanApplication;
import com.example.demo.entities.Status;
import com.example.demo.repository.LoanApplicationRepository;
import com.example.demo.service.LoanApplicationService;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LoanApplicationServiceTest {
	
	@Autowired
	@MockBean
	private LoanApplicationService loanApplicationService;
	
	@MockBean
	LoanApplicationRepository loanApplicationRepository;
	
	
	
	private LoanApplicationDto correctLoanApplicationDto ;

	private LoanApplication correctLoanApplication ;
	
	@BeforeEach
	public void setUp() {
		
		
		correctLoanApplicationDto= new LoanApplicationDto(3,LocalDate.of(2020, 10, 12),90000,	402000, "done",	"ok","approved",null);

		correctLoanApplication= new LoanApplication(3,LocalDate.of(2020, 10, 12),90000,	402000, "done",	"ok","approved",null);
		doReturn(correctLoanApplication).when(loanApplicationRepository).save(any());
//		doReturn(correctLoanApplication).when(loanApplicationService).ConvertDTOToEntity(correctLoanApplicationDto);
//		doReturn(correctLoanApplicationDto).when(loanApplicationService).ConvertEntityToDto(correctLoanApplication);

//		 ConvertDTOToEntity(loanApplicationDto)
		
		
	}

//	@Test
//	public void addNewLoanApplicationTest() {
//		
//		assertEquals(correctLoanApplication, loanApplicationService.addLoanApplication(correctLoanApplicationDto));
//		
//		
//		
//	}

}
