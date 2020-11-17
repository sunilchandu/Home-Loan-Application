package com.example.demo.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.LoanApplication;

public interface FinanceVerificationRepository extends JpaRepository<LoanApplication,Integer>{
	/*
	 * @Query(value =
	 * "update loan_application set status = 'PENDING' where id = :id") void
	 * updateStatus(@Param("id")LoanApplication loanApplication);
	 */
}
