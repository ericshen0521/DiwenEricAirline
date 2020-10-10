package com.flightsearch.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



public class FlightPathDTO implements Serializable, Cloneable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8719893337179981823L;

	private String departureAirport;
	
	private String destAirport;
	
	private String departureDate;
	
	private String arrivalDate;
	
	private String duration;
	
	private String aircraft;
	
	private String carrierCode;
	
	private String departureTerminal;
	
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
	@Override
	public String toString() {
		return "FlightPathDTO [departureAirport=" + departureAirport + ", destAirport=" + destAirport
				+ ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", duration=" + duration
				+ ", aircraft=" + aircraft + ", carrierCode=" + carrierCode + ", departureTerminal=" + departureTerminal
				+ ", arrivalTerminal=" + arrivalTerminal + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
