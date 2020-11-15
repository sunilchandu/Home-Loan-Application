package com.example.demo.service;

import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    public List<Customer> viewAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
        return customer;
    }

    public Customer viewCustomer(int customerId){
        Optional<Customer> customerOptional= customerRepository.findById(customerId);
        return customerOptional.get();
    }

    public List<Customer> viewCustomerList(LocalDate dateOfApplication) {
        return customerRepository.findByDateOfApplication(dateOfApplication);
    }

}
