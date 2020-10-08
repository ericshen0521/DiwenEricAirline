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

import com.flightsearch.DTO.UserLoginDTO;
import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.modal.CustomerModel;
import com.flightsearch.service.CustomerService;

@Controller
@ComponentScan(basePackages = "com.flightsearch.service")
public class UserController {
	
	@Autowired
	CustomerService customerService;

	//@ResponseBody
	@RequestMapping("/loginForm")
	public String goToLoginForm()
	{
		return "loginForm";
	}
	
	@RequestMapping("/registrationForm")
	public String goToRegistration()
	{
		return "registrationForm";
	}
	
	
	@PostMapping("/login")
	public String saveCustomer(@ModelAttribute(name = "loginDetails") UserLoginDTO loginDetails, Model model)
	{
		//customerService.addCustomer(customer);
		//return "Successfully added";
		model.addAttribute("loginInfo", loginDetails);
		return "displayLoginDetails";
	}
	
	@PostMapping("/register")
	public String registerAccount(@ModelAttribute(name = "registrationDetails") UserRegistrationDTO registrationDetails, Model model)
	{
		
		if(!registrationDetails.getPassword().equals(registrationDetails.getPasswordConfirm())) {
			return "registrationForm";
		}
		
		model.addAttribute("registrationDetails", registrationDetails);
		return "displayLoginDetails";
	}
	
	@GetMapping("/fetch")
	public String getCustomerDetails(Model model)
	{
		model.addAttribute("customerList",customerService.fetchCustomer());
		return "welcome";
	}
	
}
