package com.amman.finance.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amman.finance.entity.Customer;
import com.amman.finance.repository.CustomerRepository;
import com.amman.finance.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;

	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public List<Customer> getAllStudents() {

		
		return customerRepository.findAll();
	}


	@Override
	public Customer saveCustomer(Customer customer) {

		
		System.out.println("inside same customer");
		
		return customerRepository.save(customer);
	}


	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).get();
	}


	@Override
	public Customer updateLoanDetails(Customer customer) {
		return customerRepository.save(customer);
	}

}
