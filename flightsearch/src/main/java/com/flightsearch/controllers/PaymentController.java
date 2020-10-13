package com.flightsearch.controllers;



import java.io.IOException;
import java.text.SimpleDateFormat;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.flightsearch.DAO.TicketDAOImpl;
import com.flightsearch.DTO.PaymentInfoDTO;
import com.flightsearch.DTO.TicketDTO;
import com.flightsearch.DTO.TicketInfoDTO;
import com.flightsearch.DTO.UserLoginDTO;
import com.flightsearch.service.UserService;
import com.flightsearch.model.LocationInfo;
import com.flightsearch.model.PaymentModel;
import com.flightsearch.model.TicketInfo;
import com.flightsearch.model.UserModel;
import com.flightsearch.service.FlightSearchService;
import com.flightsearch.service.PaymentService;

@Controller
@ComponentScan(basePackages = "com.flightsearch.service")
@SessionAttributes({"user", "selectedTicket"})
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	@Autowired
	FlightSearchService FlightSearchService;
	
	@RequestMapping("payment")
	public String temp(){
		return "paymentForm";
	}
	
	@RequestMapping("/cancelPayment")
	public String cancel(HttpSession session){
		session.removeAttribute("selectedTicket");
		return "index";
	}
	
	@RequestMapping("/paymentForm")
	public String goToPaymentForm(HttpSession session){
		TicketInfo ticket = (TicketInfo)session.getAttribute("ticket");
		//if user does something tricky
		if(ticket == null) {
			return "index";
		}
		
		return "paymentForm";
	}
	
	@PostMapping("/pay")
	public ModelAndView goToPaymentForm(@ModelAttribute(name = "paymentFormDetails") PaymentInfoDTO paymentFormDetails, Model model, HttpSession session){
		System.out.println("session test 2: " + session.getAttribute("selectedTicket"));
		TicketInfo ticket = (TicketInfo)session.getAttribute("selectedTicket");
		UserModel user = (UserModel) session.getAttribute("user");
		ticket.setOwnedBy(user);
		FlightSearchService.updateTicketInfo(ticket);
		
		user.addTicket(ticket);
		
		
		PaymentModel paymentModel = paymentService.saveOrder(paymentFormDetails, ticket);
		
		return new ModelAndView("showPaymentInfo", "paymentModel", paymentModel);
	}

}

