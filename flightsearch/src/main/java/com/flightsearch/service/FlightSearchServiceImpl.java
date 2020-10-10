package com.flightsearch.service;


import com.amadeus.referenceData.Locations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import com.flightsearch.model.LocationInfo;
import com.flightsearch.model.Ticket;
import com.flightsearch.model.TicketInfo;

@Service
public class FlightSearchServiceImpl implements FlightSearchService{
	
	@Override
	@ModelAttribute("code")
	public List<LocationInfo> getLocation(String cityName) {
		// TODO Auto-generated method stub
		Location[] locations;
		List<LocationInfo> location_info;
		location_info = new ArrayList<LocationInfo>();
		try {
			locations = amadeus.referenceData.locations.get(Params
				      .with("keyword", cityName)
				      .and("subType", Locations.CITY));
			if(locations[0].getResponse().getStatusCode() != 200) {
		        System.out.println("Wrong status code: " + locations[0].getResponse().getStatusCode());
		        System.exit(-1);
		    }
		    System.out.println(locations[0]);
		    for (Location loc : locations) {
		    	String city = loc.getName();
		    	System.out.println("city: " + city);
		    	String iataCode = loc.getIataCode();
		    	LocationInfo locInfo = new LocationInfo(city, iataCode);
		    	location_info.add(locInfo);
		    }
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return location_info;
	}
	

	@Override
	public List<TicketInfo> getTicketInfo(Ticket ticket) {
		FlightOfferSearch[] flightOffersSearches;
		List<TicketInfo> ticketList;
		ticketList = new ArrayList<TicketInfo>();
		try {
			flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
			        Params.with("originLocationCode", ticket.getDepartCity())
			                .and("destinationLocationCode", ticket.getDestCity())
			                .and("departureDate", ticket.getDepartDate())
			                .and("returnDate", ticket.getReturnDate())
			                .and("adults", Integer.parseInt(ticket.getNumOfAdults()))
			                .and("max", Integer.parseInt(ticket.getNumOfAdults()) + Integer.parseInt(ticket.getNumOfChildren())));
			System.out.println(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getDeparture());
			System.out.println(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getArrival());
			System.out.println(flightOffersSearches[0].getItineraries()[0].getDuration());
			System.out.println(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getAircraft());
			System.out.println(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getCarrierCode());
			TicketInfo ticketInfo = new TicketInfo();
			ticketInfo.setAircraft(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getAircraft().getCode());
			ticketInfo.setCarriercode(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getCarrierCode());
			ticketInfo.setDepartCity(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getDeparture().getIataCode());
			ticketInfo.setDepartTerminal(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getDeparture().getTerminal());
			ticketInfo.setDestCity(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getArrival().getIataCode());
			ticketInfo.setDestTerminal(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getArrival().getTerminal());
			ticketInfo.setDuration(flightOffersSearches[0].getItineraries()[0].getDuration());
			ticketList.add(ticketInfo);
//			for (int i = 0; i < flightOffersSearches.length; i ++) {
//				for (int j = 0; j < flightOffersSearches[i].getItineraries().length; j ++) {
//					
//				}
//			}
			 if (flightOffersSearches[0].getResponse().getStatusCode() != 200) {
			      System.out.println("Wrong status code: " + flightOffersSearches[0].getResponse().getStatusCode());
			      System.exit(-1);
			  }
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ticketList;
	}

}
