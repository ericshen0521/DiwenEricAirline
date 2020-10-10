package com.flightsearch.service;



import java.util.List;


import com.amadeus.Amadeus;
import com.flightsearch.model.LocationInfo;
import com.flightsearch.model.Ticket;
import com.flightsearch.model.TicketInfo;


public interface FlightSearchService {
	static final Amadeus amadeus = Amadeus
	        .builder("NBV4ImwrZn1BBE15vGNuQN6uDMSoIrfV","Hkomko31BaUcIGGv")
	        .build();
	public List<LocationInfo> getLocation(String cityName);
	public List<TicketInfo> getTicketInfo(Ticket ticket);
}
