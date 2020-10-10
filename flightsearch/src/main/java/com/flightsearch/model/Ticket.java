<<<<<<< HEAD:flightsearch/src/main/java/com/flightsearch/DTO/TicketDTO.java
package com.flightsearch.DTO;
=======
package com.flightsearch.model;
>>>>>>> AccountModule:flightsearch/src/main/java/com/flightsearch/model/Ticket.java

import java.io.Serializable;

public class TicketDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7946570404121183045L;
	private String departCity;
	private String destCity;
	private String departDate;
	private String returnDate;
	private String numOfAdults;
	private String numOfChildren;
	private String travelClass;
	private String departCode;
	private String destCode;
	public String getDepartCode() {
		return departCode;
	}
	public void setDepartCode(String departCode) {
		this.departCode = departCode;
	}
	public String getDestCode() {
		return destCode;
	}
	public void setDestCode(String destCode) {
		this.destCode = destCode;
	}
	public String getDepartCity() {
		return departCity;
	}
	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}
	public String getDestCity() {
		return destCity;
	}
	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}
	

	
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getNumOfAdults() {
		return numOfAdults;
	}
	public void setNumOfAdults(String numOfAdults) {
		this.numOfAdults = numOfAdults;
	}
	public String getNumOfChildren() {
		return numOfChildren;
	}
	public void setNumOfChildren(String numOfChildren) {
		this.numOfChildren = numOfChildren;
	}
	public String getTravelClass() {
		return travelClass;
	}
	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
	@Override
	public String toString() {
		return "TicketDTO [departCity=" + departCity + ", destCity=" + destCity + ", departDate=" + departDate
				+ ", returnDate=" + returnDate + ", numOfAdults=" + numOfAdults + ", numOfChildren=" + numOfChildren
				+ ", travelClass=" + travelClass + ", departCode=" + departCode + ", destCode=" + destCode + "]";
	}
	
	

	
	
}
