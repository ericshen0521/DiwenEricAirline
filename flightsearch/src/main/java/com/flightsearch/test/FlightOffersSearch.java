package com.flightsearch.test;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;

public class FlightOffersSearch {

  public static void main(String[] args) throws ResponseException {

    Amadeus amadeus = Amadeus
        .builder("NBV4ImwrZn1BBE15vGNuQN6uDMSoIrfV","Hkomko31BaUcIGGv")
        .build();

    FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
                  Params.with("originLocationCode", "CHI")
                          .and("destinationLocationCode", "SEA")
                          .and("departureDate", "2020-10-13")
                          .and("returnDate", "2020-10-18")
                          .and("adults", 2)
                          .and("max", 3));

    if (flightOffersSearches[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + flightOffersSearches[0].getResponse().getStatusCode());
        System.exit(-1);
    }
    System.out.println(flightOffersSearches.length);
    System.out.println(flightOffersSearches[2].getItineraries()[0].getSegments().length);
    System.out.println(flightOffersSearches[2].getItineraries()[0].getSegments()[0].getDeparture());
	System.out.println(flightOffersSearches[2].getItineraries()[0].getSegments()[0].getArrival());
	System.out.println(flightOffersSearches[2].getItineraries()[0].getSegments()[1].getDeparture());
	System.out.println(flightOffersSearches[2].getItineraries()[0].getSegments()[1].getAircraft().getCode());
	System.out.println(flightOffersSearches[2].getItineraries()[0].getSegments()[1].getCarrierCode());
	System.out.println(flightOffersSearches[0].getPrice().getTotal());
	System.out.println(flightOffersSearches[0].getNumberOfBookableSeats());
//	System.out.println(flightOffersSearches[0].getPricingOptions());
//	System.out.println(flightOffersSearches[2].getItineraries()[0].getDuration());
//	System.out.println(flightOffersSearches[2].getItineraries()[0].getSegments()[0].getAircraft());
//	System.out.println(flightOffersSearches[2].getItineraries()[0].getSegments()[0].getCarrierCode());
  }
}