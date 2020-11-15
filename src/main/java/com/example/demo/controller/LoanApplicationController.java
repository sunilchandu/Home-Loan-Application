package com.example.demo.controller;

import com.example.demo.service.ILoanApplicationService;
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
  public List<LoanApplication> getAllApplications() {
       return service.retrieveAllLoanApplication();
   }
   
   
   
   @GetMapping("{loan-application-id}")
	public ResponseEntity<LoanApplication> getById(
			@PathVariable("loan-application-id")Integer loanApplicationId){
		LoanApplication loanApplication= service.retrieveLoanApplicationById(loanApplicationId);
   
		if( loanApplication==null) {
			return new ResponseEntity("Sorry! ProductsId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<LoanApplication>(loanApplication, HttpStatus.OK);
	}
   
   @PostMapping
   public LoanApplication addNewCustomer(@RequestBody LoanApplication loanApplication) {
     
       return service.addLoanApplication(loanApplication);
   }
   
   @PutMapping
	public ResponseEntity<List<LoanApplication>> updateLoanApplication(
			@RequestBody LoanApplication loanApplication){
		List<LoanApplication> loanApplications= service.updateLoanApplication(loanApplication);
		if(loanApplications.isEmpty())
		{
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<LoanApplication>>(loanApplications, HttpStatus.OK);
	}
   
   @DeleteMapping("{loan-application-id}")
	public ResponseEntity<List<LoanApplication>> deleteLoanApplication(
			@PathVariable("loan-application-id")Integer loanApplicationId){
		List<LoanApplication> loanApplications= service.deleteLoanApplication(loanApplicationId);
		if(loanApplications.isEmpty() || loanApplications==null) {
			return new ResponseEntity("Sorry! ProductsId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<LoanApplication>>(loanApplications, HttpStatus.OK);
	}
   

   

   
}
