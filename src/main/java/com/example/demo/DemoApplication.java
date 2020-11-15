package com.example.demo;

import com.example.demo.service.CustomerService;
import com.example.demo.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private LoanApplicationService loanApplicationService;

	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("done succesfully");
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
