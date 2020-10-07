package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.CustomerModel;
import com.spring.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	//@ResponseBody
	@RequestMapping("/go")
	public String goToBrowser()
	{
		return "userEntry";
	}

	@ResponseBody
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute(name = "customerAttribute") CustomerModel customer)
	{
		customerService.addCustomer(customer);
		return "Successfully added";
	}
	
	@GetMapping("/fetch")
	public String getCustomerDetails(Model model)
	{
		model.addAttribute("customerList",customerService.fetchCustomer());
		return "welcome";
	}
	
}
