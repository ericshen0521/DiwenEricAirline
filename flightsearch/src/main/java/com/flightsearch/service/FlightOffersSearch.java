package com.flightsearch.service;

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
                          .and("destinationLocationCode", "SFO")
                          .and("departureDate", "2020-11-01")
                          .and("returnDate", "2020-11-08")
                          .and("adults", 2)
                          .and("max", 3));

    if (flightOffersSearches[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + flightOffersSearches[0].getResponse().getStatusCode());
        System.exit(-1);
    }
    System.out.println(flightOffersSearches[0]);
    System.out.println(flightOffersSearches[0].getChoiceProbability());
    System.out.println(flightOffersSearches[0].getId());
    System.out.println(flightOffersSearches[0].getLastTicketingDate());
    System.out.println(flightOffersSearches[0].getNumberOfBookableSeats());
    System.out.println(flightOffersSearches[0].getSource());
    System.out.println(flightOffersSearches[0].getType());
    System.out.println(flightOffersSearches[0].getClass());
    System.out.println(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getDeparture());
    System.out.println(flightOffersSearches[0].getItineraries()[0].getSegments()[0].getArrival());
    
    System.out.println(flightOffersSearches[0].getItineraries()[1].getSegments()[0].getDeparture());
    System.out.println(flightOffersSearches[0].getItineraries()[1].getSegments()[0].getArrival());

    
  }
}