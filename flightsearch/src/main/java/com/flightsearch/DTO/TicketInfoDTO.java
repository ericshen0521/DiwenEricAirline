package com.flightsearch.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;




public class TicketInfoDTO implements Serializable, Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3581720504188034457L;

	private List<FlightPathDTO> goList;
	
	private List<FlightPathDTO> backList;
	
	private int availableSeats;

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
	public List<FlightPathDTO> getGoList() {
		return goList;
	}
	public void setGoList(List<FlightPathDTO> goList) {
		this.goList = goList;
	}
	public List<FlightPathDTO> getBackList() {
		return backList;
	}
	public void setBackList(List<FlightPathDTO> backList) {
		this.backList = backList;
	}
	

	@Override
	public String toString() {
		return "TicketInfoDTO [goList=" + goList + ", backList=" + backList + ", availableSeats=" + availableSeats
				+ ", totalPrice=" + totalPrice + "]";
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		TicketInfoDTO t = new TicketInfoDTO();
		System.out.println("clone before go: " + this.goList.size());
		System.out.println("clone before back: " + this.backList.size());
		ListIterator<FlightPathDTO> litr = this.goList.listIterator();
		List<FlightPathDTO> firstList = new ArrayList<FlightPathDTO>();
		while(litr.hasNext()) {
			firstList.add((FlightPathDTO)(litr.next().clone()));
		}
		
		List<FlightPathDTO> secondList = new ArrayList<FlightPathDTO>();
		litr = this.backList.listIterator();
		while(litr.hasNext()) {
			secondList.add((FlightPathDTO)(litr.next().clone()));
		}
		System.out.println("clone after go: " + firstList.size());
		System.out.println("clone after back: " + backList.size());
		t.setGoList(firstList);
		t.setBackList(secondList);
		t.setAvailableSeats(this.availableSeats);
		t.setTotalPrice(this.totalPrice);
		return t;
	}
	
	
	
}
