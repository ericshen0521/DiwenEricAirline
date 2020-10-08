package com.flightsearch.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flightsearch.modal.LocationInfo;
import com.flightsearch.service.CustomerService;
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
	
//	@RequestMapping(value = "/show", method = RequestMethod.POST)
//	public String showInfo(@ModelAttribute("ticket") Ticket ticket) {
//		
//	}
	
	private List<LocationInfo> simulateSearchResult(String cityName) {
		System.out.println("Test inside SearchResult: " + cityName);
		List<LocationInfo> result = flightSearchService.getLocation(cityName);
		System.out.println(result.size());
		return result;
	}
	
}

