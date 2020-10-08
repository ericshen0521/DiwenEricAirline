package com.flightsearch.modal;

import org.springframework.stereotype.Component;

@Component
public class LocationInfo {
	private String cityName;
	private String iataCode;

	public LocationInfo() {
		
	}
	public LocationInfo(String cityName, String iataCode) {
		this.cityName = cityName;
		this.iataCode = iataCode;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
