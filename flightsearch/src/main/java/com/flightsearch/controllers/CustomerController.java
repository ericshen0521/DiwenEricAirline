package com.flightsearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flightsearch.modal.CustomerModel;
import com.flightsearch.service.CustomerService;

@Controller
@ComponentScan(basePackages = "com.flightsearch.service")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	//@ResponseBody
	@RequestMapping("/go")
	public String goToBrowser()
	{
		return "loginForm";
	}

	@PostMapping("/login")
	public String saveCustomer(@ModelAttribute(name = "customerAttribute") CustomerModel customer, Model model)
	{
		//customerService.addCustomer(customer);
		//return "Successfully added";
		model.addAttribute("customer", customer);
		return "displayLoginDetails";
	}
	
	@GetMapping("/fetch")
	public String getCustomerDetails(Model model)
	{
		model.addAttribute("customerList",customerService.fetchCustomer());
		return "welcome";
	}
	
}
