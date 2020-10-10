package com.flightsearch.service;



import java.util.List;



import com.amadeus.Amadeus;

import com.flightsearch.DTO.TicketDTO;
import com.flightsearch.DTO.TicketInfoDTO;
import com.flightsearch.model.LocationInfo;



public interface FlightSearchService {
	static final Amadeus amadeus = Amadeus
	        .builder("NBV4ImwrZn1BBE15vGNuQN6uDMSoIrfV","Hkomko31BaUcIGGv")
	        .build();
	public List<LocationInfo> getLocation(String cityName);
	public List<TicketInfoDTO> getTicketInfo(TicketDTO ticket);
	public int insertTicketInfo(TicketInfoDTO ticketInfoDTO);
}
