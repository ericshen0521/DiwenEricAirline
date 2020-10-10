package com.flightsearch.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flightsearch.DTO.FlightPathDTO;
import com.flightsearch.DTO.TicketInfoDTO;
import com.flightsearch.model.FlightPathBack;
import com.flightsearch.model.FlightPathGo;
import com.flightsearch.model.TicketInfo;



@Transactional
@Repository
@ComponentScan(basePackages = "com.flightsearch")
public class TicketDAOImpl implements TicketDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public int save(TicketInfoDTO ticketInfoDTO) {
		// TODO Auto-generated method stub
		TicketInfo ticket = new TicketInfo();
		TicketInfoDTO cloneTicket;
		try {
			cloneTicket = (TicketInfoDTO) ticketInfoDTO.clone();
			ticket.setAvailableSeats(cloneTicket.getAvailableSeats());
			ListIterator<FlightPathDTO> litr = cloneTicket.getGoList().listIterator();
			List<FlightPathGo> newGoList = new ArrayList<FlightPathGo>();
			while(litr.hasNext()) {
				FlightPathGo f = new FlightPathGo();
				FlightPathDTO fdt = litr.next();
				f.setAircraft(fdt.getAircraft());
				f.setArrivalDate(fdt.getArrivalDate());
				f.setArrivalTerminal(fdt.getArrivalTerminal());
				f.setCarrierCode(fdt.getCarrierCode());
				f.setDepartureAirport(fdt.getDepartureAirport());
				f.setDepartureDate(fdt.getDepartureDate());
				f.setDepartureTerminal(fdt.getDepartureTerminal());
				f.setDestAirport(fdt.getDestAirport());
				f.setDuration(fdt.getDuration());
				newGoList.add(f);
			}
			litr = cloneTicket.getBackList().listIterator();
			List<FlightPathBack> newBackList = new ArrayList<FlightPathBack>();
			while(litr.hasNext()) {
				FlightPathBack f = new FlightPathBack();
				FlightPathDTO fdt = litr.next();
				f.setAircraft(fdt.getAircraft());
				f.setArrivalDate(fdt.getArrivalDate());
				f.setArrivalTerminal(fdt.getArrivalTerminal());
				f.setCarrierCode(fdt.getCarrierCode());
				f.setDepartureAirport(fdt.getDepartureAirport());
				f.setDepartureDate(fdt.getDepartureDate());
				f.setDepartureTerminal(fdt.getDepartureTerminal());
				f.setDestAirport(fdt.getDestAirport());
				f.setDuration(fdt.getDuration());
				newBackList.add(f);
			}
			ticket.setGoList(newGoList);
			ticket.setBackList(newBackList);
			ticket.setTotalPrice(cloneTicket.getTotalPrice());
			ticket.setAvailableSeats(cloneTicket.getAvailableSeats());
			
			int ticketID = (Integer)getSession().save(ticket);
			return ticketID;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}
