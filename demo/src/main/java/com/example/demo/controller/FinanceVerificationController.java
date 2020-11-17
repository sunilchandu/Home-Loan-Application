package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LoanApplication;
import com.example.demo.service.FinanceVerificationService;

@RestController
@RequestMapping(value = { "/finance" })
public class FinanceVerificationController {

	@Autowired
	FinanceVerificationService financeService;

	@PutMapping
	public void addNewLoanApplication(@RequestBody LoanApplication loanApplication) {
		financeService.updateStatus(loanApplication);
	}

}
