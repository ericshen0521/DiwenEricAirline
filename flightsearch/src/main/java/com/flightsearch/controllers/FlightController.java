package com.flightsearch.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.flightsearch.modal.LocationInfo;
import com.flightsearch.modal.Ticket;
import com.flightsearch.modal.TicketInfo;
import com.flightsearch.service.UserService;
import com.flightsearch.service.FlightSearchService;

@Controller
@ComponentScan(basePackages = "com.flightsearch.service")
public class FlightController {
	@Autowired
	FlightSearchService flightSearchService;
	
	List<Tag> data = new ArrayList<Tag>();
	public FlightController() {
		data.add(new Tag(1, "ruby"));
		data.add(new Tag(2, "rails"));
		data.add(new Tag(3, "c / c++"));
		data.add(new Tag(4, ".net"));
		data.add(new Tag(5, "python"));
		data.add(new Tag(6, "java"));
		data.add(new Tag(7, "javascript"));
		data.add(new Tag(8, "jscript"));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage() {
		return "index";
	}
	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody List<LocationInfo> getTags(@RequestParam String cityName) {
		System.out.println("good!!");
		return simulateSearchResult(cityName);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String showInfo(@ModelAttribute("ticket") Ticket ticket, Model model) {
		System.out.println("departCity: " + ticket.getDepartCity());
		System.out.println("destCity: " + ticket.getDestCity());
		System.out.println("numberOfAdults: " + ticket.getNumOfAdults());
		System.out.println("numberOfChildren: " + ticket.getNumOfChildren());
		System.out.println("class: " + ticket.getTravelClass());
		System.out.println("departdate: " + ticket.getDepartDate());
		System.out.println("arrivaldate: " + ticket.getReturnDate());
		System.out.println("departcode: " + ticket.getDepartCode());
		System.out.println("destCode: " + ticket.getDestCode());
		List<TicketInfo> ticketList = flightSearchService.getTicketInfo(ticket);
		model.addAttribute("dept", ticketList.get(0).getDepartCity());
		model.addAttribute("deptterminal", ticketList.get(0).getDepartTerminal());
		model.addAttribute("dest", ticketList.get(0).getDestCity());
		model.addAttribute("destterminal", ticketList.get(0).getDestTerminal());
		model.addAttribute("aircraft", ticketList.get(0).getAircraft());
		model.addAttribute("carriercode", ticketList.get(0).getCarriercode());
		model.addAttribute("duration", ticketList.get(0).getDuration());
		
		return "showinfo";
	}
	


	
	private List<LocationInfo> simulateSearchResult(String cityName) {
		System.out.println("Test inside SearchResult: " + cityName);
		List<LocationInfo> result = flightSearchService.getLocation(cityName);
		System.out.println(result.size());
		return result;
	}
	
}

