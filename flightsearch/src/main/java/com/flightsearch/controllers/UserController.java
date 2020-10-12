package com.flightsearch.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.flightsearch.DTO.UserLoginDTO;
import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.model.TicketInfo;
import com.flightsearch.model.UserModel;
import com.flightsearch.service.UserService;
import com.flightsearch.validator.LoginValidator;
import com.flightsearch.validator.RegistrationValidator;

@Controller
@ComponentScan(basePackages = "com.flightsearch.service")
@SessionAttributes({ "user", "previousRequest", "selectedTicket" })
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	private RegistrationValidator registrationValidator;

	@Autowired
	private LoginValidator loginValidator;

	@InitBinder("loginDetails")
	protected void initBinderLogin(WebDataBinder binder) {
		binder.addValidators(loginValidator);
	}

	@InitBinder("registrationDetails")
	protected void initBinderRegistration(WebDataBinder binder) {
		binder.addValidators(registrationValidator);
	}

	// @ResponseBody
	@RequestMapping("/loginForm")
	public String goToLoginForm(HttpServletRequest request) {
		return "loginForm";
	}

	@RequestMapping("/registrationForm")
	public String goToRegistration() {
		return "registrationForm";
	}

	@RequestMapping("/displayLoginDetails")
	public String goToDisplayLoginDetails() {
		return "displayLoginDetails";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute(name = "loginDetails") UserLoginDTO loginDetails, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		// customerService.addCustomer(customer);
		// return "Successfully added";

		UserModel user = userService.fetchUserByLogin(loginDetails.getEmail(), loginDetails.getPassword());
		if (user == null) {
			model.addAttribute("error", "Invalid Credentials");
			return "loginForm";
		}
		model.addAttribute("user", user);

		TicketInfo ticket = (TicketInfo)session.getAttribute("selectedTicket");
//		System.out.println("before ticket nuill check");
		//if user came after selecting a ticket
		if(ticket != null) {
//			System.out.println("after ticket nuil check");
			return "paymentForm";
		}
		
		return "index";
	}

	@RequestMapping("/logout")
	public String save(SessionStatus status) {
		status.setComplete();
		return "index";
	}
	

	@PostMapping("/register")
	public String registerAccount(
			@ModelAttribute(name = "registrationDetails") @Validated UserRegistrationDTO registrationDetails,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "registrationForm";
		}

		model.addAttribute("registrationDetails", registrationDetails);
		userService.registerUser(registrationDetails);

		return "displayRegistrationDetails";
	}


}
