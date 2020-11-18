package com.example.demo.controller;

import com.example.demo.service.ILoanApplicationService;
import com.example.demo.dto.LoanApplicationDto;
import com.example.demo.entities.LoanApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/loan-application"})
public class LoanApplicationController {

    @Autowired
    ILoanApplicationService service;

   @GetMapping
  public ResponseEntity<List<LoanApplicationDto>> getAllApplications() {
	   
	   List<LoanApplicationDto> loanApplications= service.retrieveAllLoanApplication();
	   
	   if(loanApplications.isEmpty() || loanApplications==null) {
			return new ResponseEntity("Sorry! ProductsId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
	   return new ResponseEntity<List<LoanApplicationDto>>(loanApplications, HttpStatus.OK);	   
   }
   
   
   
   @GetMapping("{loan-application-id}")
	public ResponseEntity<LoanApplicationDto> getById(
			@PathVariable("loan-application-id")Integer loanApplicationId){
	   LoanApplicationDto loanApplication= service.retrieveLoanApplicationById(loanApplicationId);
   
		if( loanApplication==null) {
			return new ResponseEntity("Sorry! ProductsId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<LoanApplicationDto>(loanApplication, HttpStatus.OK);
	}
   
   @PostMapping
   public LoanApplicationDto addLoanApplication(@RequestBody LoanApplicationDto loanApplicationDto) {
     
       return service.addLoanApplication(loanApplicationDto);
   }
   
   @PutMapping
	public ResponseEntity<List<LoanApplicationDto>> updateLoanApplication(
			@RequestBody LoanApplicationDto loanApplicationDto){
		List<LoanApplicationDto> loanApplications= service.updateLoanApplication(loanApplicationDto);
		if(loanApplications.isEmpty())
		{
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<LoanApplicationDto>>(loanApplications, HttpStatus.OK);
	}
   
   @DeleteMapping("{loan-application-id}")
	public ResponseEntity<List<LoanApplicationDto>> deleteLoanApplication(
			@PathVariable("loan-application-id")Integer loanApplicationId){
		List<LoanApplicationDto> loanApplications= service.deleteLoanApplication(loanApplicationId);
		if(loanApplications.isEmpty() || loanApplications==null) {
			return new ResponseEntity("Sorry! ProductsId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<LoanApplicationDto>>(loanApplications, HttpStatus.OK);
	}
   

   

   
}
