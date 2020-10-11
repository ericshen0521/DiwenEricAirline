package com.flightsearch.controllers;



import java.text.SimpleDateFormat;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.flightsearch.DTO.TicketDTO;
import com.flightsearch.DTO.TicketInfoDTO;
import com.flightsearch.service.UserService;
import com.flightsearch.model.LocationInfo;
import com.flightsearch.model.TicketInfo;
import com.flightsearch.model.UserModel;
import com.flightsearch.service.FlightSearchService;

@Controller
@ComponentScan(basePackages = "com.flightsearch.service")
@SessionAttributes({"user", "selectedTicket"})
public class PaymentController {
	@Autowired
	FlightSearchService flightSearchService;
	
	@RequestMapping("payment")
	public String temp(){
		return "paymentForm";
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
	
//	@PostMapping("/pay")
//	public String goToPaymentForm(){
//		
//	}
	
	
	
}

