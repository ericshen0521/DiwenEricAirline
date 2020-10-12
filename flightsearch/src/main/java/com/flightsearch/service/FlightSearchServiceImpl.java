package com.flightsearch.service;


import com.amadeus.referenceData.Locations;
import com.flightsearch.DAO.TicketDAO;
import com.flightsearch.DTO.FlightPathDTO;
import com.flightsearch.DTO.TicketDTO;
import com.flightsearch.DTO.TicketInfoDTO;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import com.flightsearch.model.LocationInfo;
import com.flightsearch.model.TicketInfo;


@Service
@ComponentScan(basePackages = "com.flightsearch.DAO")
public class FlightSearchServiceImpl implements FlightSearchService{
	
	@Autowired
	private TicketDAO ticketDAO;
	
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
		    for (Location loc : locations) {
		    	String city = loc.getName();
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
	public List<TicketInfoDTO> getTicketInfo(TicketDTO ticket) {
		FlightOfferSearch[] flightOffersSearches;
		List<TicketInfoDTO> ticketList;
		System.out.println("departcity: " + ticket.getDepartCity() + "  " + ticket.getDepartCity().length());
		System.out.println("destcity: " + ticket.getDestCity() + " " + ticket.getDestCity().length());
		ticketList = new ArrayList<TicketInfoDTO>();
		try {
			flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
			        Params.with("originLocationCode", ticket.getDepartCity())
			                .and("destinationLocationCode", ticket.getDestCity())
			                .and("departureDate", ticket.getDepartDate())
			                .and("returnDate", ticket.getReturnDate())
			                .and("adults", 1)
			                .and("max", 5));
			System.out.println("flightoffersearch length: " + flightOffersSearches.length);
			
			for (int i = 0; i < flightOffersSearches.length; i ++) {
				TicketInfoDTO ticketInfo = new TicketInfoDTO();
				List<FlightPathDTO> first = new ArrayList<FlightPathDTO>();
				List<FlightPathDTO> second = new ArrayList<FlightPathDTO>();
				for (int j = 0; j < flightOffersSearches[i].getItineraries()[0].getSegments().length; j ++) {
					FlightPathDTO flightPath = new FlightPathDTO();
					flightPath.setArrivalDate(flightOffersSearches[i].getItineraries()[0].getSegments()[j].getArrival().getAt());
					flightPath.setAircraft(flightOffersSearches[i].getItineraries()[0].getSegments()[j].getAircraft().getCode());
					flightPath.setArrivalTerminal(flightOffersSearches[i].getItineraries()[0].getSegments()[j].getArrival().getTerminal());
					flightPath.setCarrierCode(flightOffersSearches[i].getItineraries()[0].getSegments()[j].getCarrierCode());
					flightPath.setDepartureAirport(flightOffersSearches[i].getItineraries()[0].getSegments()[j].getDeparture().getIataCode());
					flightPath.setDepartureDate(flightOffersSearches[i].getItineraries()[0].getSegments()[j].getDeparture().getAt());
					flightPath.setDepartureTerminal(flightOffersSearches[i].getItineraries()[0].getSegments()[j].getDeparture().getTerminal());
					flightPath.setDestAirport(flightOffersSearches[i].getItineraries()[0].getSegments()[j].getArrival().getIataCode());
					flightPath.setDuration(flightOffersSearches[i].getItineraries()[0].getSegments()[j].getDuration());
					first.add(flightPath);
				}
				
				for (int j = 0; j < flightOffersSearches[i].getItineraries()[1].getSegments().length; j ++) {
					FlightPathDTO flightPath = new FlightPathDTO();
					flightPath.setArrivalDate(flightOffersSearches[i].getItineraries()[1].getSegments()[j].getArrival().getAt());
					flightPath.setAircraft(flightOffersSearches[i].getItineraries()[1].getSegments()[j].getAircraft().getCode());
					flightPath.setArrivalTerminal(flightOffersSearches[i].getItineraries()[1].getSegments()[j].getArrival().getTerminal());
					flightPath.setCarrierCode(flightOffersSearches[i].getItineraries()[1].getSegments()[j].getCarrierCode());
					flightPath.setDepartureAirport(flightOffersSearches[i].getItineraries()[1].getSegments()[j].getDeparture().getIataCode());
					flightPath.setDepartureDate(flightOffersSearches[i].getItineraries()[1].getSegments()[j].getDeparture().getAt());
					flightPath.setDepartureTerminal(flightOffersSearches[i].getItineraries()[1].getSegments()[j].getDeparture().getTerminal());
					flightPath.setDestAirport(flightOffersSearches[i].getItineraries()[1].getSegments()[j].getArrival().getIataCode());
					flightPath.setDuration(flightOffersSearches[i].getItineraries()[1].getSegments()[j].getDuration());
					second.add(flightPath);
				}
				ticketInfo.setGoList(first);
				ticketInfo.setBackList(second);
				double price = flightOffersSearches[i].getPrice().getTotal() * (Integer.parseInt(ticket.getNumOfAdults()) + 
						Integer.parseInt(ticket.getNumOfChildren()));
				ticketInfo.setTotalPrice(flightOffersSearches[i].getPrice().getTotal());
				ticketInfo.setAvailableSeats(flightOffersSearches[i].getNumberOfBookableSeats());
				ticketList.add(ticketInfo);
			}
			//TODO
			//will crash if no offers found
			 if (flightOffersSearches[0].getResponse().getStatusCode() != 200) {
			      System.out.println("Wrong status code: " + flightOffersSearches[0].getResponse().getStatusCode());
			      System.exit(-1);
			  }
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ticketList length: " + ticketList.size());
		return ticketList;
	}
	
	@Override
	public TicketInfo insertTicketInfo(TicketInfoDTO ticketInfoDTO) {
		TicketInfo ticket = ticketDAO.save(ticketInfoDTO);
		return ticket;
	}

}
