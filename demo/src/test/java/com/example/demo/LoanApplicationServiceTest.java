package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.dto.LoanApplicationDto;
import com.example.demo.dto.Status;
import com.example.demo.entities.LoanApplication;
import com.example.demo.entities.StatusEntity;
import com.example.demo.exception.ApplicationAlreadyExists;
import com.example.demo.exception.ApplicationIdNotFound;
import com.example.demo.repository.LoanApplicationRepository;
import com.example.demo.service.Convertor;
import com.example.demo.service.ILoanApplicationService;
import com.example.demo.service.LoanApplicationService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoanApplicationServiceTest {

	@Autowired
	private ILoanApplicationService loanApplicationService;

	@MockBean
	LoanApplicationRepository loanApplicationRepository;
	@MockBean
	Convertor convertor;

	private LoanApplicationDto correctLoanApplicationDto;

	private LoanApplication correctLoanApplication;

	private LoanApplicationDto correctLoanApplicationDto1;

	private LoanApplication correctLoanApplication1;

	public void SetUp() {

		correctLoanApplicationDto = new LoanApplicationDto(3, LocalDate.of(2020, 10, 12), 90000, 402000, "done", "ok",
				"approved", null, Status.APPROVED);

		correctLoanApplication = new LoanApplication(3, LocalDate.of(2020, 10, 12), 90000, 402000, "done", "ok",
				"approved", null, StatusEntity.APPROVED);
		doReturn(correctLoanApplication).when(loanApplicationRepository).save(any());
		doReturn(correctLoanApplication).when(convertor).ConvertDTOToEntity(correctLoanApplicationDto);
		doReturn(correctLoanApplicationDto).when(convertor).ConvertEntityToDto(correctLoanApplication);

	}

	public void getByIdSetUp() {
		correctLoanApplicationDto1 = new LoanApplicationDto(3, LocalDate.of(2020, 10, 12), 90000, 402000, "done", "ok",
				"approved", null,Status.APPROVED);

		correctLoanApplication1 = new LoanApplication(3, LocalDate.of(2020, 10, 12), 90000, 402000, "done", "ok",
				"approved", null,StatusEntity.APPROVED);
		doReturn(correctLoanApplication1).when(convertor).ConvertDTOToEntity(correctLoanApplicationDto1);
		doReturn(correctLoanApplicationDto).when(convertor).ConvertEntityToDto(correctLoanApplication1);
//		doReturn(correctLoanApplicationDto1).when(convertor).ConvertEntityToDto(Optional.of(correctLoanApplication1).get());

	}

//	public void updateSetUp() {
//
//		correctLoanApplication = new LoanApplication(3, LocalDate.of(2020, 10, 12), 90000, 402000, "done", "ok",
//				"approved", null);
//
//		correctLoanApplicationDto1 = new LoanApplicationDto(3, LocalDate.of(2020, 10, 12), 10000, 402000, "done", "ok",
//				"approved", null);
//
//		doReturn(correctLoanApplication).when(convertor).ConvertDTOToEntity(correctLoanApplicationDto1);
//		doReturn(correctLoanApplicationDto1).when(convertor).ConvertEntityToDto(correctLoanApplication);
//		doReturn(correctLoanApplication).when(loanApplicationRepository).save(any());
//		doReturn(Optional.of(correctLoanApplication)).when(loanApplicationRepository)
//		.findById(correctLoanApplication.getId());
//
//	}

	@Order(1)
	@Test
	public void addNewLoanApplicationTest() throws ApplicationAlreadyExists {
		SetUp();

		assertEquals(correctLoanApplication.getId(),
				loanApplicationService.addLoanApplication(correctLoanApplicationDto).getApplicationId());

	}

	@Order(2)
	@Test
	public void addExistingLoanApplicationTest() {
		SetUp();

		doReturn(Optional.of(correctLoanApplicationDto)).when(loanApplicationRepository)
				.findById(correctLoanApplication.getId());

		ApplicationAlreadyExists applicationAlreadyExists = assertThrows(ApplicationAlreadyExists.class,
				() -> loanApplicationService.addLoanApplication(correctLoanApplicationDto));
		assertTrue(applicationAlreadyExists.getMessage().contains("ApplicationAlreadyExists"));

	}

	@Order(3)
	@Test
	public void testNullBean() throws ApplicationAlreadyExists {
		correctLoanApplicationDto = null;
		assertNull(loanApplicationService.addLoanApplication(correctLoanApplicationDto));
	}

	@Order(4)
	@Test
	public void getByApplicationIdTest() throws ApplicationIdNotFound {
		getByIdSetUp();

		doReturn(Optional.of(correctLoanApplication1)).when(loanApplicationRepository)
				.findById(correctLoanApplication1.getId());

		assertEquals(correctLoanApplicationDto1.getApplicationId(), loanApplicationService
				.retrieveLoanApplicationById(correctLoanApplicationDto1.getApplicationId()).getApplicationId());
	}

	@Order(5)
	@Test
	public void getEmptyApplicationId() throws ApplicationIdNotFound {
		getByIdSetUp();
		correctLoanApplication = new LoanApplication(5, LocalDate.of(2020, 10, 12), 90000, 402000, "done", "ok",
				"approved", null,StatusEntity.APPROVED);
		doReturn(Optional.of(correctLoanApplication1)).when(loanApplicationRepository)
				.findById(correctLoanApplication1.getId());

		ApplicationIdNotFound applicationIdNotFound = assertThrows(ApplicationIdNotFound.class,
				() -> loanApplicationService.retrieveLoanApplicationById(correctLoanApplication.getId()));
		assertTrue(applicationIdNotFound.getMessage().contains("ApplicationIdNotFound"));

	}

	@Test
	public void updateNewLoanApplicationTest() throws ApplicationIdNotFound {
		SetUp();
//		updateSetUp();
		doReturn(Optional.of(correctLoanApplication)).when(loanApplicationRepository)
				.findById(correctLoanApplication.getId());

		correctLoanApplication.setLoanAppliedAmount(10000);

		assertEquals(correctLoanApplication.getLoanAppliedAmount(),
				loanApplicationService.updateLoanApplication(correctLoanApplicationDto).getLoanAppliedAmount());

	}

	@Test
	public void updateEmptyLoanApplication() throws ApplicationIdNotFound {
		SetUp();
//		updateSetUp();
		doReturn(Optional.of(correctLoanApplication)).when(loanApplicationRepository)
				.findById(correctLoanApplication.getId());

		correctLoanApplicationDto = new LoanApplicationDto(5, LocalDate.of(2020, 10, 12), 90000, 402000, "done", "ok",
				"approved", null,Status.APPROVED);

		ApplicationIdNotFound applicationIdNotFound = assertThrows(ApplicationIdNotFound.class,
				() -> loanApplicationService.updateLoanApplication(correctLoanApplicationDto));

		assertTrue(applicationIdNotFound.getMessage().contains("ApplicationIdNotFound"));

	}
	
	@Test
	public void deleteExistingUserTest() throws ApplicationIdNotFound {
		SetUp();
		doReturn(Optional.of(correctLoanApplication)).when(loanApplicationRepository)
		.findById(correctLoanApplication.getId());
        
		doNothing().when(loanApplicationRepository).deleteById(any());
		assertEquals(correctLoanApplication.getId(),
				loanApplicationService.deleteLoanApplication(correctLoanApplicationDto.getApplicationId()).getApplicationId());
	}
	@Test
	public void deleteEmptyUserTest() throws ApplicationIdNotFound {
		
		
		correctLoanApplication = new LoanApplication(3, LocalDate.of(2020, 10, 12), 90000, 402000, "done", "ok",
				"approved", null,StatusEntity.APPROVED);

		correctLoanApplicationDto = new LoanApplicationDto(5, LocalDate.of(2020, 10, 12), 90000, 402000, "done", "ok",
				"approved", null,Status.APPROVED);
		doReturn(Optional.of(correctLoanApplication)).when(loanApplicationRepository)
		.findById(correctLoanApplication.getId());
		
		ApplicationIdNotFound applicationIdNotFound = assertThrows(ApplicationIdNotFound.class,
				() -> loanApplicationService.updateLoanApplication(correctLoanApplicationDto));

		assertTrue(applicationIdNotFound.getMessage().contains("ApplicationIdNotFound"));

		
	}
	
	@Test
	public void emptyLoanApplicationsTest() {
		
		doReturn(null).when(loanApplicationRepository).findAll();
		
		assertNull(loanApplicationService.retrieveAllLoanApplication());
		
	}
	
	@Test
	public void testRetrieveLoanApplication() {
		correctLoanApplicationDto = new LoanApplicationDto(3, LocalDate.of(2020, 10, 12), 90000, 402000, "done", "ok",
				"approved", null,Status.APPROVED);
		
		List<LoanApplication> list = new ArrayList<LoanApplication>();
		

		correctLoanApplication = new LoanApplication(3, LocalDate.of(2020, 10, 12), 90000, 402000, "done", "ok",
				"approved", null,StatusEntity.APPROVED);
		list.add(correctLoanApplication);
		
		doReturn(list).when(loanApplicationRepository).findAll();
		doReturn(correctLoanApplicationDto).when(convertor).ConvertEntityToDto(correctLoanApplication);
		assertNotNull(loanApplicationService.retrieveAllLoanApplication());
		
	}

}
