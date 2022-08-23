package com.amman.finance.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amman.finance.entity.Customer;
import com.amman.finance.entity.DaySheet;
import com.amman.finance.service.CustomerService;

@Controller

public class LoanController {
	
	private CustomerService customerService;
	
	public LoanController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}


	@GetMapping("updateView")
	public String menu() {

		return "update-daybook";
	}
	 
	
	
	@RequestMapping("/customers")
	public String listCustomer(Model model) {

		model.addAttribute("customers", customerService.getAllStudents());
		return "view-daybook";
		
	}
	
	@RequestMapping("/customers/new")
	public String addCustomer(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";

	}

	
	@PostMapping("/customers")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		
		Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = simpleDateFormat.format(date);

        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
	    
	    customer.setCreatedDate(date1);
		
		customerService.saveCustomer(customer);
		
		return "redirect:/customers";
		
	}
	
	@GetMapping("/customer/edit/{customerId}") 
	public String editCustomerLoanDetails(@PathVariable Long customerId,Model model) {
		
		System.out.println("inside edit customer details ----->"+customerId);
		model.addAttribute("customer",customerService.getCustomerById(customerId));
		return "update-daybook";
		

	}
	
	@PostMapping("/customers/{id}")
	public String updateCustomerLoanDetails(@PathVariable Long id,@ModelAttribute("customer") Customer customer,Model model) {
		
		System.out.println("inside update customer details --->");
		Customer existingCustomer = customerService.getCustomerById(id);
		existingCustomer.setCustomerId(id);
		existingCustomer.setFirstName((customer.getFirstName()));
		
		
		
		customerService.updateLoanDetails(existingCustomer);
		
		
		return "redirect:/customers";
		

	}
	
	
	
	
	
}
