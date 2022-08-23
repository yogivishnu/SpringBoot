package com.amman.finance.service;

import java.util.List;

import com.amman.finance.entity.Customer;

public interface CustomerService {

	
	List<Customer> getAllStudents(); 
	Customer saveCustomer(Customer customer);
	Customer getCustomerById(Long id);
	Customer updateLoanDetails(Customer customer);
	
}
