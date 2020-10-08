package com.flightsearch.service;


import com.amadeus.referenceData.Locations;
import com.flightsearch.modal.LocationInfo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;

@Service
public class FlightSearchServiceImpl implements FlightSearchService{
	
	@Override
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
	
	public static void main(String[] args) throws ResponseException {
		Location[] locations = amadeus.referenceData.locations.get(Params
			      .with("keyword", "LON")
			      .and("subType", Locations.ANY));

			    if(locations[0].getResponse().getStatusCode() != 200) {
			        System.out.println("Wrong status code: " + locations[0].getResponse().getStatusCode());
			        System.exit(-1);
			    }
			    System.out.println(locations[0]);
	}

}
