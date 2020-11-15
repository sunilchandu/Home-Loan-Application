package com.example.demo.controller;

import com.example.demo.service.CustomerService;
import com.example.demo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/customer"})
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.viewAllCustomers();
    }

    @PostMapping
    public Customer addNewCustomer(@RequestBody Customer customer) {
        System.out.println(customer.getDateOfBirth());
        return service.addCustomer(customer);
    }

    @GetMapping(value = {"/date-of-application/{date}"})
    public List<Customer> findAllCustomersByDateOfApplication(@Param("date") String dateOfApplication) {
        System.out.println(dateOfApplication);
        return null;
        //return service.viewCustomerList(LocalDate.parse(dateOfApplication));
    }
}
