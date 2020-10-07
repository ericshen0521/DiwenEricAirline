package com.flightsearch.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FlightController {
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
	public @ResponseBody List<Tag> getTags(@RequestParam String tagName) {
		System.out.println("good!!");
		return simulateSearchResult(tagName);
	}
	
	private List<Tag> simulateSearchResult(String tagName) {
		System.out.println("Test inside SearchResult: " + tagName);
		List<Tag> result = new ArrayList<Tag>();
		for (Tag tag : data) {
			System.out.println("Inside Tage for: " + tag.getTagName());
			if (tag.getTagName().contains(tagName)) {
				System.out.println("1");
				result.add(tag);
			}
		}
		return result;
	}
	
}

