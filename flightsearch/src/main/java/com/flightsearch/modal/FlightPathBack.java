package com.flightsearch.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class FlightPathBack {

	@Column(name = "DEPART_AIRPORT")
	private String departureAirport;
	@Column(name = "DEST_AIRPORT")
	private String destAirport;
	@Column(name = "DEPART_DATE")
	private String departureDate;
	@Column(name = "DEST_DATE")
	private String arrivalDate;
	@Column(name = "DURATION")
	private String duration;
	@Column(name = "AIRCRAFT")
	private String aircraft;
	@Column(name = "CARRIER_ID")
	private String carrierCode;
	@Column(name = "DEPT_TERMINAL")
	private String departureTerminal;
	@Column(name = "ARRIVAL_TERMINAL")
	private String arrivalTerminal;
	

	public String getDepartureTerminal() {
		return departureTerminal;
	}
	public void setDepartureTerminal(String departureTerminal) {
		this.departureTerminal = departureTerminal;
	}
	public String getArrivalTerminal() {
		return arrivalTerminal;
	}
	public void setArrivalTerminal(String arrivalTerminal) {
		this.arrivalTerminal = arrivalTerminal;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getDestAirport() {
		return destAirport;
	}
	public void setDestAirport(String destAirport) {
		this.destAirport = destAirport;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAircraft() {
		return aircraft;
	}
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	public String getCarrierCode() {
		return carrierCode;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	
}
