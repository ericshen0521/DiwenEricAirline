package com.flightsearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flightsearch.DTO.UserLoginDTO;
import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.modal.CustomerModel;
import com.flightsearch.service.CustomerService;
import com.flightsearch.validator.UserValidator;

@Controller
@ComponentScan(basePackages = "com.flightsearch.service")
public class UserController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	private UserValidator userValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

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
	public String registerAccount(@ModelAttribute(name = "registrationDetails") @Validated UserRegistrationDTO registrationDetails, BindingResult result, Model model)
	{
		
		if(result.hasErrors()) {
			return "registrationForm";
		}
		
		model.addAttribute("registrationDetails", registrationDetails);
		return "displayRegistrationDetails";
	}
	
	
	@GetMapping("/fetch")
	public String getCustomerDetails(Model model)
	{
		model.addAttribute("customerList",customerService.fetchCustomer());
		return "welcome";
	}
	
}
