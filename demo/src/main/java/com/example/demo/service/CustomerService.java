package com.example.demo.service;

import com.example.demo.dto.Customer;
import org.apache.log4j.Logger;
import com.example.demo.entities.CustomerEntity;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	static Logger log = Logger.getLogger(CustomerService.class.getName());  
	public List<Customer> viewAllCustomers() {
		log.info("starting of the view all customers method");
		List<Customer> custList = new ArrayList<Customer>();
		List<CustomerEntity> custEntity = customerRepository.findAll();
		for (CustomerEntity Cust : custEntity) {
			custList.add(ConvertEntityToDTO(Cust));
		}
		log.info("end of the view all customers method");
		return custList;
		// return customerRepository.findAll();
	}

	public Customer addCustomer(Customer customer) {
		// return customerRepository.save(customer);
		CustomerEntity custEntity = ConvertDTOToEntity(customer);
		return ConvertEntityToDTO(customerRepository.save(custEntity));
	}

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<CustomerEntity> customerOptional = customerRepository
				.findById(ConvertDTOToEntity(customer).getUserId());
		if (customerOptional.isPresent()) {
			return ConvertEntityToDTO(customerRepository.save(ConvertDTOToEntity(customer)));
		}
		throw new CustomerNotFoundException("Customer not found with id: " + ConvertDTOToEntity(customer).getUserId());
	}

	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<CustomerEntity> customerOptional = customerRepository
				.findById(ConvertDTOToEntity(customer).getUserId());
		if (customerOptional.isPresent()) {
			customerRepository.deleteById(ConvertDTOToEntity(customer).getUserId());
			return customer;
		}
		throw new CustomerNotFoundException("Customer not found with id: " + ConvertDTOToEntity(customer).getUserId());
	}

	public Customer deleteCustomerById(int id) throws CustomerNotFoundException {
		Optional<CustomerEntity> customerOptional = customerRepository.findById(id);
		if (customerOptional.isPresent()) {
			customerRepository.deleteById(id);
			return ConvertEntityToDTO(customerOptional.get());
		}
		throw new CustomerNotFoundException("Customer not found with id: " + id);
	}

	public Customer viewCustomer(int customerId) throws CustomerNotFoundException {
		Optional<CustomerEntity> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent()) {
			return ConvertEntityToDTO(customerOptional.get());
		}
		throw new CustomerNotFoundException("Customer not found with id: " + customerId);
	}

	public CustomerEntity ConvertDTOToEntity(Customer cust) {
		CustomerEntity custEntity = new CustomerEntity();
		custEntity.setUserId(cust.getUserId());
		custEntity.setCustomerName(cust.getCustomerName());
		custEntity.setAadharNumber(cust.getAadharNumber());
		custEntity.setDateOfBirth(cust.getDateOfBirth());
		custEntity.setEmailId(cust.getEmailId());
		custEntity.setGender(cust.getGender());
		custEntity.setMobileNumber(cust.getMobileNumber());
		custEntity.setNationality(cust.getNationality());
		custEntity.setPanNumber(cust.getPanNumber());
		return custEntity;
	}

	public Customer ConvertEntityToDTO(CustomerEntity custEntity) {
		Customer cust = new Customer();
		cust.setUserId(custEntity.getUserId());
		cust.setCustomerName(custEntity.getCustomerName());
		cust.setAadharNumber(custEntity.getAadharNumber());
		cust.setDateOfBirth(custEntity.getDateOfBirth());
		cust.setEmailId(custEntity.getEmailId());
		cust.setGender(custEntity.getGender());
		cust.setMobileNumber(custEntity.getMobileNumber());
		cust.setNationality(custEntity.getNationality());
		cust.setPanNumber(custEntity.getPanNumber());
		return cust;
	}

}
