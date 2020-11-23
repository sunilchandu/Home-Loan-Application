package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.LoanApplication;
import com.example.demo.entities.StatusEntity;
import com.example.demo.repository.FinanceVerificationRepository;

@Service
public class FinanceVerificationService  {
@Autowired
private FinanceVerificationRepository financeRepository;
	

 public void updateStatus(LoanApplication loanApplication) {
	 loanApplication.setStatus(StatusEntity.PENDING);
  financeRepository.save(loanApplication); 
  }
}
