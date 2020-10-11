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
@SessionAttributes({"user", "previousRequest", "selectedTicket"})
public class FlightController {
	@Autowired
	FlightSearchService flightSearchService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage() {
		return "index";
	}
	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody List<LocationInfo> getTags(@RequestParam String cityName) {
		return simulateSearchResult(cityName);
	}
	
	
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public ModelAndView showInfo(@ModelAttribute("ticket") TicketDTO ticket, Model model) {
		List<TicketInfoDTO> ticketList = flightSearchService.getTicketInfo(ticket);
		return new ModelAndView("showinfo", "tickets", ticketList);
	}
	
	@PostMapping(value = "/selectTicket")
	public ModelAndView checkout(@ModelAttribute("ticketinfo") TicketInfoDTO ticket, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("inside checkout: " + ticket.getAvailableSeats());
		System.out.println("inside checkout go list: " + ticket.getGoList().size());
		System.out.println("inside checkout go list 1: " + ticket.getGoList().get(0).getAircraft());
		System.out.println("inside checkout go list 2: " + ticket.getBackList().get(0).getAircraft());
		
		TicketInfo ticketInfo = flightSearchService.insertTicketInfo(ticket);
		model.addAttribute("ticketid", ticketInfo.getId());
		session.setAttribute("selectedTicket", ticketInfo);
		
		UserModel user = (UserModel) session.getAttribute("user");
		if(user == null) {
			
			return new ModelAndView("loginForm");
		}
		
		
		return new ModelAndView("paymentForm", "selectedTicket", model);
	}


	
	private List<LocationInfo> simulateSearchResult(String cityName) {
		List<LocationInfo> result = flightSearchService.getLocation(cityName);
		return result;
	}
	
}

