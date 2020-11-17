package com.example.demo.controller;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.service.CustomerService;
import com.example.demo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/customer"})
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomers() {
    	System.out.println(service.viewAllCustomers());
        return service.viewAllCustomers();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCustomerById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(service.viewCustomer(id));
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Customer addNewCustomer(@RequestBody Customer customerEntity) {
        return service.addCustomer(customerEntity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        customer.setUserId(id);
        try {
            return ResponseEntity.ok(service.updateCustomer(customer));
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(service.deleteCustomerById(id));
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /*@DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        customer.setUserId(id);
        try {
            return ResponseEntity.ok(service.deleteCustomer(customer));
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }*/
}
