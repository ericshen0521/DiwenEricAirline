package com.flightsearch.modal;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
public class TicketInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TICKET_ID")
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ElementCollection
	@CollectionTable(
			name="FLIGHTPATHGO",
			joinColumns = @JoinColumn(name="GO_ID")
	)
	private List<FlightPathGo> goList;
	
	@ElementCollection
	@CollectionTable(
			name="FLIGHTPATHBACK",
			joinColumns = @JoinColumn(name="BACK_ID")
	)
	private List<FlightPathBack> backList;
	
	@Column(name = "AVAILABLESEATS")
	private int availableSeats;
	@Column(name = "TOTALPRICE")
	private double totalPrice;
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<FlightPathGo> getGoList() {
		return goList;
	}
	public void setGoList(List<FlightPathGo> goList) {
		this.goList = goList;
	}
	public List<FlightPathBack> getBackList() {
		return backList;
	}
	public void setBackList(List<FlightPathBack> backList) {
		this.backList = backList;
	}

	
	
	
}
